package com.amarinag.amgmoviedb.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
data class Genre(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("name")
        @Expose
        val name: String = ""
) {
    override fun toString() = name
}