package com.amarinag.amgmoviedb.network

import com.amarinag.amgmoviedb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   20/4/18
 */
@Singleton
class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url()

        val url = originalUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.MOVIEDB_API)
                .build()

        val requestBuilder = original.newBuilder().url(url)
        return chain.proceed(requestBuilder.build())
    }
}