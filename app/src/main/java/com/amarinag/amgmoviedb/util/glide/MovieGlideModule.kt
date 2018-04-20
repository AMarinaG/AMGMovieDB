package com.amarinag.amgmoviedb.util.glide

import android.content.Context
import android.util.Log

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   21/4/18
 */
@GlideModule
class MovieGlideModule : AppGlideModule() {

    fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setLogLevel(Log.WARN)
    }
}
