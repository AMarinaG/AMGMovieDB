package com.amarinag.amgmoviedb.ui.main

import android.support.v7.util.DiffUtil
import com.amarinag.amgmoviedb.model.Movie

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie?, newItem: Movie?) = oldItem?.id == newItem?.id

    override fun areContentsTheSame(oldItem: Movie?, newItem: Movie?) = oldItem == newItem
}