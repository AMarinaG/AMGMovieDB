package com.amarinag.amgmoviedb.ui.main

import android.databinding.DataBindingUtil
import android.support.v4.content.ContextCompat
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ItemMovieBinding
import com.amarinag.amgmoviedb.model.Movie

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
class MovieAdapter(private val clickListener: (Movie, List<View>) -> Unit, private val favoriteClickListener: (Movie) -> Unit) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding: ItemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener, favoriteClickListener)

    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: (Movie, List<View>) -> Unit, favoriteClickListener: (Movie) -> Unit) {
            binding.movie = movie
            binding.root.setOnClickListener { clickListener(movie, arrayListOf(binding.ivPoster, binding.tvTitle, binding.tvOverview)) }
            val icFavorite = if (movie.favorite) R.drawable.ic_favorite_pink_24dp else R.drawable.ic_favorite_border_pink_24dp
            binding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(itemView.context, icFavorite))
            binding.ivFavorite.setOnClickListener { favoriteClickListener(movie) }
        }
    }
}

