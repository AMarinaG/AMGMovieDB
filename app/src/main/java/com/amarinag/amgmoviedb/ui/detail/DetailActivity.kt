package com.amarinag.amgmoviedb.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityDetailBinding
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setSupportActionBar(binding.toolbar)
        detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        detailViewModel.getMovie(intent.getIntExtra(EXTRA_MOVIE_ID, -1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            if (response.isSuccessful) {
                                binding.movie = response.body()
                            }
                        },
                        { error ->
                            Timber.e(error, "Ha habido un error!")
                        }

                )
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
