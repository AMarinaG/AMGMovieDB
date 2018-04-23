package com.amarinag.amgmoviedb.ui.detail

import android.arch.lifecycle.ViewModel
import com.amarinag.amgmoviedb.domain.interactor.AddFavoriteInteractor
import com.amarinag.amgmoviedb.domain.interactor.GetMovieDetailInteractor
import com.amarinag.amgmoviedb.domain.interactor.RemoveFavoriteInteractor
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
class DetailViewModel @Inject constructor(
        private val getMovieDetailInteractor: GetMovieDetailInteractor,
        private val addFavoriteInteractor: AddFavoriteInteractor,
        private val removeFavoriteInteractor: RemoveFavoriteInteractor) : ViewModel() {

    fun getMovie(movieId: Long) = getMovieDetailInteractor.invoke(movieId)
    fun addFavorite(movieId: Long) = addFavoriteInteractor.invoke(movieId)
    fun removeFavorite(movieId: Long) = removeFavoriteInteractor.invoke(movieId)
}
