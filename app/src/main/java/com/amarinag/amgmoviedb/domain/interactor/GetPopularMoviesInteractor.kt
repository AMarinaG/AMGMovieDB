package com.amarinag.amgmoviedb.domain.interactor

import com.amarinag.amgmoviedb.domain.repository.movie.MovieRepository
import com.amarinag.amgmoviedb.model.Popular
import io.reactivex.Flowable
import retrofit2.Response
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
class GetPopularMoviesInteractor @Inject constructor(private val movieRepository: MovieRepository) {
    fun invoke(page: Int): Flowable<Response<Popular>> = movieRepository.getPopularMovies(page).map {
        it.body()?.results?.forEach {
            it.favorite = movieRepository.getFavorite(it.id)?.isFavorite ?: false
        }
        it
    }.toFlowable()


}