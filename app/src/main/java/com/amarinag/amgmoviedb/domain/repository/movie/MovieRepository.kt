package com.amarinag.amgmoviedb.domain.repository.movie

import com.amarinag.amgmoviedb.model.Favorite
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
class MovieRepository @Inject constructor(private val movieRemoteRepository: MovieRemoteRepository, private val movieLocalRepository: MovieLocalRepository) {
    fun getPopularMovies(page: Int = 1) = movieRemoteRepository.getPopularMovies(page)

    fun getMovie(movieId: Long) = movieRemoteRepository.getMovie(movieId)

    fun getFavorite(movieId: Long) = movieLocalRepository.getFavorite(movieId)

    fun addFavorite(movieId: Long) = movieLocalRepository.addFavorite(Favorite(movieId, true))

    fun removeFavorite(movieId: Long) = movieLocalRepository.removeFavorite(movieId)
}