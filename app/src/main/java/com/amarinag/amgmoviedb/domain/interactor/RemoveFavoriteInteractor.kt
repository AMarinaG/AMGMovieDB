package com.amarinag.amgmoviedb.domain.interactor

import com.amarinag.amgmoviedb.domain.repository.movie.MovieRepository
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
class RemoveFavoriteInteractor @Inject constructor(private val movieRepository: MovieRepository) {
//    fun invoke(movieId: Long) = movieRepository.removeFavorite(movieId)
}
