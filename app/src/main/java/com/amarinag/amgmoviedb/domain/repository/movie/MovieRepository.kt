package com.amarinag.amgmoviedb.domain.repository.movie

import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
class MovieRepository @Inject constructor(private val movieRemoteRepository: MovieRemoteRepository) {
    fun getPopularMovies(page: Int = 1) = movieRemoteRepository.getPopularMovies(page)

    fun getMovie(movieId: Int) = movieRemoteRepository.getMovie(movieId)
}