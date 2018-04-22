package com.amarinag.amgmoviedb.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import com.amarinag.amgmoviedb.model.Favorite

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
@Dao
interface FavoriteDao {
    @Insert
    fun addFavorite(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)
}