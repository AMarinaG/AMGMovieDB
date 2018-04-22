package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModel
import com.amarinag.amgmoviedb.domain.interactor.AddFavoriteInteractor
import com.amarinag.amgmoviedb.domain.interactor.GetPopularMoviesInteractor
import com.amarinag.amgmoviedb.domain.interactor.RemoveFavoriteInteractor
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
class MainViewModel @Inject constructor(
        private val getPopularMoviesInteractor: GetPopularMoviesInteractor,
        private val addFavoriteInteractor: AddFavoriteInteractor,
        private val removeFavoriteInteractor: RemoveFavoriteInteractor) : ViewModel() {
    fun getPopular(page: Int) = getPopularMoviesInteractor.invoke(page)

    fun addFavorite(movieId: Long) = addFavoriteInteractor.invoke(movieId)
//    fun removeFavorite(movieId: Long) = removeFavoriteInteractor.invoke(movieId)
}