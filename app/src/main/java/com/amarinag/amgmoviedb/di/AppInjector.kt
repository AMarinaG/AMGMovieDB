package com.amarinag.amgmoviedb.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.amarinag.amgmoviedb.App
import com.amarinag.amgmoviedb.di.component.DaggerAppComponent
import com.amarinag.amgmoviedb.ui.base.BaseActivity
import dagger.android.AndroidInjection

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
object AppInjector {
    fun init(app: App) {
        DaggerAppComponent.builder().application(app).build().inject(app)
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
                handleActivity(activity)
            }

        })

    }

    private fun handleActivity(activity: Activity?) {
        if (activity is BaseActivity) {
            AndroidInjection.inject(activity)
        }
    }
}