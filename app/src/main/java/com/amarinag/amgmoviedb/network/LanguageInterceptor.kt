package com.amarinag.amgmoviedb.network

import android.os.Build
import com.amarinag.amgmoviedb.App
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
class LanguageInterceptor @Inject constructor(private val app: App) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url()
        val currentLocale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            app.resources.configuration.locales[0]
        } else {
            app.resources.configuration.locale
        }
        val url = originalUrl.newBuilder()
                .addQueryParameter("language", "${currentLocale.language}-${currentLocale.country}")
                .build()

        val requestBuilder = original.newBuilder().url(url)
        return chain.proceed(requestBuilder.build())
    }
}