package com.amarinag.amgmoviedb.network

import com.amarinag.amgmoviedb.model.Popular
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
interface MovieDbService {
    @GET("popular")
    fun getPopularMovies(): Call<Response<Popular>>
}