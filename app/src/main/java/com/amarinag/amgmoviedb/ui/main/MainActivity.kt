package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityMainBinding
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        val adapter = MovieAdapter({ movie -> Timber.d("Has pulsado la peli: %s", movie) })
        binding.rvMovies.layoutManager = GridLayoutManager(this, 2)
        binding.rvMovies.adapter = adapter
        mainViewModel.getPopular(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            if (response.isSuccessful) {
                                adapter.submitList(response.body()?.results)
                            }
                        },
                        { error ->
                            Timber.e(error, "Ha habido un error!")
                        }

                )
    }
}
