package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityMainBinding
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import com.amarinag.amgmoviedb.ui.detail.DetailActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var page: Int = 1
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        adapter = MovieAdapter(
                { movie, list ->
                    val pair = Pair(list[0], ViewCompat.getTransitionName(list[0]))
                    val pair2 = Pair(list[1], ViewCompat.getTransitionName(list[1]))
                    val pair3 = Pair(list[2], ViewCompat.getTransitionName(list[2]))
                    DetailActivity.start(this@MainActivity, movie.id, ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, pair, pair2, pair3))

                },
                { movie ->
                    if (movie.favorite) {
                        mainViewModel.removeFavorite(movie.id)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(
                                        {
                                            movie.favorite = false
                                            adapter.notifyDataSetChanged()
                                        },
                                        {
                                            Timber.e(it, "Error al salvar favorito: ${it.message}")
                                        })
                    } else {
                        mainViewModel.addFavorite(movie.id)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(
                                        {
                                            movie.favorite = true
                                            adapter.notifyDataSetChanged()
                                        },
                                        {
                                            Timber.e(it, "Error al salvar favorito: ${it.message}")
                                        })
                    }
                })
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
        binding.rvMovies.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    override fun onResume() {
        super.onResume()
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
