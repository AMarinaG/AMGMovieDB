package com.amarinag.amgmoviedb.util.binding

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.amarinag.amgmoviedb.BuildConfig
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.util.glide.GlideApp

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   21/4/18
 */
@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    GlideApp.with(this.context)
            .load("${BuildConfig.IMAGE_URL}/$url")
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fitCenter()
            .into(this)
}