package com.amarinag.amgmoviedb.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.amarinag.amgmoviedb.model.Favorite

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
@Database(version = 1, entities = [Favorite::class], exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}