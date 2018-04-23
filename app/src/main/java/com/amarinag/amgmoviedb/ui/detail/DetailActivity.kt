package com.amarinag.amgmoviedb.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityDetailBinding
import com.amarinag.amgmoviedb.model.Movie
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setSupportActionBar(binding.toolbar)
        detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        detailViewModel.getMovie(intent.getLongExtra(EXTRA_MOVIE_ID, -1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            if (response.isSuccessful) {
                                movie = response.body()!!
                                binding.movie = movie
                                val icFavorite = if (movie.favorite) R.drawable.ic_favorite_pink_24dp else R.drawable.ic_favorite_border_pink_24dp
                                binding.fab.setImageResource(icFavorite)
                                binding.fab.setOnClickListener { _ -> switchFavorite() }
                            }
                        },
                        { error ->
                            Timber.e(error, "Ha habido un error!")
                        }

                )
    }

    private fun switchFavorite() {
        if (movie.favorite) {
            detailViewModel.removeFavorite(movie.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                movie.favorite = false
                                binding.fab.setImageResource(R.drawable.ic_favorite_border_pink_24dp)
                            },
                            {
                                Timber.e(it, "Error al salvar favorito: ${it.message}")
                            })
        } else {
            detailViewModel.addFavorite(movie.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                movie.favorite = true
                                binding.fab.setImageResource(R.drawable.ic_favorite_pink_24dp)
                            },
                            {
                                Timber.e(it, "Error al salvar favorito: ${it.message}")
                            })
        }
    }

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
        @JvmStatic
        fun start(context: Context, movieId: Long, activityOptionsCompat: ActivityOptionsCompat) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            context.startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}
