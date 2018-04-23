package com.amarinag.amgmoviedb.domain.interactor

import com.amarinag.amgmoviedb.domain.repository.movie.MovieRepository
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
class GetMovieDetailInteractor @Inject constructor(private val movieRepository: MovieRepository) {
    fun invoke(movieId: Long) = movieRepository.getMovie(movieId)
            .map {
                it.body()?.favorite = movieRepository.getFavorite(it.body()?.id!!)?.isFavorite ?: false
                it
            }
            .toFlowable()
}