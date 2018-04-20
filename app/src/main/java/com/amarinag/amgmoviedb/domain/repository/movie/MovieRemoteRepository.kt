package com.amarinag.amgmoviedb.domain.repository.movie

import com.amarinag.amgmoviedb.network.MovieDbService
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
class MovieRemoteRepository @Inject constructor(private val movieDbService: MovieDbService){
    fun getPopularMovies(page: Int) = movieDbService.getPopularMovies(page)
}