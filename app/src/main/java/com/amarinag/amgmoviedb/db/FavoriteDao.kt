package com.amarinag.amgmoviedb.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.amarinag.amgmoviedb.model.Favorite

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite WHERE movieId = :movieId")
    fun getFavoriteById(movieId: Long): Favorite?

    @Insert
    fun addFavorite(favorite: Favorite): Long

    @Delete
    fun deleteFavorite(favorite: Favorite)
}