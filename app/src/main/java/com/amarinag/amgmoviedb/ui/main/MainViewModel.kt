package com.amarinag.amgmoviedb.ui.main

import android.arch.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
class MainViewModel @Inject constructor() : ViewModel() {
    init {
        Timber.d("Se ha iniciado MainViewModel")
    }
}