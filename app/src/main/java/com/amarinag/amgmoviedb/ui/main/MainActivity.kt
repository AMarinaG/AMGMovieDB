package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityMainBinding
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import com.amarinag.amgmoviedb.util.LinearMarginItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var page: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        val adapter = MovieAdapter(
                { movie -> Timber.d("Has pulsado la peli: %s", movie) },
                { movie -> Timber.d("Hacemos favorito la pelicula: %s", movie) })
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
        binding.rvMovies.addItemDecoration(LinearMarginItemDecoration(20, LinearLayoutManager.VERTICAL))
        mainViewModel.getPopular(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            if (response.isSuccessful) {

                                page = page.unaryPlus()
                                adapter.submitList(response.body()?.results)
                            }
                        },
                        { error ->
                            Timber.e(error, "Ha habido un error!")
                        }

                )
    }
}
