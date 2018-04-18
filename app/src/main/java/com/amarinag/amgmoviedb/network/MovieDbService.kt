package com.amarinag.amgmoviedb.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
interface MovieDbService {
    @GET("popular")
    fun getPopularMovies(): Call<ResponseBody>
}