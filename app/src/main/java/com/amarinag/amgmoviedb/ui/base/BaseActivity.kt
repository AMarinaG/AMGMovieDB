package com.amarinag.amgmoviedb.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}