package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModel
import com.amarinag.amgmoviedb.domain.interactor.GetPopularMoviesInteractor
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
class MainViewModel @Inject constructor(private val getPopularMoviesInteractor: GetPopularMoviesInteractor) : ViewModel() {
    fun getPopular(page: Int) = getPopularMoviesInteractor.invoke(page)
}