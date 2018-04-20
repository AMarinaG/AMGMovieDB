package com.amarinag.amgmoviedb.di.module

import com.amarinag.amgmoviedb.BuildConfig
import com.amarinag.amgmoviedb.di.ViewModelModule
import com.amarinag.amgmoviedb.network.MovieDbService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
        builder.addNetworkInterceptor(StethoInterceptor())
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun providesMovieDbService(okHttpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MovieDbService::class.java)
}