package com.amarinag.amgmoviedb.di.module

import com.amarinag.amgmoviedb.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}