package com.amarinag.amgmoviedb.network

import com.amarinag.amgmoviedb.model.Movie
import com.amarinag.amgmoviedb.model.Popular
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
interface MovieDbService {
    @GET("popular")
    fun getPopularMovies(@Query("page") page: Int = 1): Single<Response<Popular>>

    @GET("{movie_id}")
    fun getMovie(@Path("movie_id") movieId: Long): Single<Response<Movie>>
}