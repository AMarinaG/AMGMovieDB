package com.amarinag.amgmoviedb.util.glide

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   21/4/18
 */
@GlideModule
class MovieGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setLogLevel(Log.DEBUG)
    }
}
