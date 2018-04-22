package com.amarinag.amgmoviedb.domain.repository.movie

import com.amarinag.amgmoviedb.db.AppDatabase
import com.amarinag.amgmoviedb.model.Favorite
import javax.inject.Inject

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
class MovieLocalRepository @Inject constructor(appDatabase: AppDatabase) {
    private val favoriteDao by lazy { appDatabase.favoriteDao() }

    fun getFavorite(movieId: Long) = favoriteDao.getFavoriteById(movieId)

    fun addFavorite(favorite: Favorite) = favoriteDao.addFavorite(favorite)
    fun removeFavorite(movieId: Long) = favoriteDao.deleteFavorite(Favorite(movieId, false))
}