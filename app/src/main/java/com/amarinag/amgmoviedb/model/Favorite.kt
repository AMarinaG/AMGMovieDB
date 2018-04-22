package com.amarinag.amgmoviedb.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
@Entity(tableName = "favorite")
data class Favorite(
        @ColumnInfo(name = "movieId")
        @PrimaryKey(autoGenerate = false)
        var movieId: Long = 0,
        val isFavorite: Boolean
)