package com.amarinag.amgmoviedb.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
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
    lateinit var mIdlingResource: IdlingResource

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    @VisibleForTesting
    fun getIdlingResource(): IdlingResource {
        return mIdlingResource
    }
}