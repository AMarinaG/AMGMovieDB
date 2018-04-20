package com.amarinag.amgmoviedb.domain.interactor

import com.amarinag.amgmoviedb.domain.repository.movie.MovieRepository
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
class GetPopularMoviesInteractor @Inject constructor(private val movieRepository: MovieRepository) {
    fun invoke(page: Int) = movieRepository.getPopularMovies(page)

}