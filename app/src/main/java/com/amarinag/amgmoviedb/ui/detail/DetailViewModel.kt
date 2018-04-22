package com.amarinag.amgmoviedb.ui.detail

import android.arch.lifecycle.ViewModel
import com.amarinag.amgmoviedb.domain.interactor.GetMovieDetailInteractor
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
class DetailViewModel @Inject constructor(private val getMovieDetailInteractor: GetMovieDetailInteractor) : ViewModel() {
    fun getMovie(movieI: Int) = getMovieDetailInteractor.invoke(movieI)
}
