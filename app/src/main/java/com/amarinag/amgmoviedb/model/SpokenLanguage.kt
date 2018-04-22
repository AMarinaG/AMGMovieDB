package com.amarinag.amgmoviedb.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
data class SpokenLanguage(
        @SerializedName("iso_639_1")
        @Expose
        val iso6391: String? = null,
        @SerializedName("name")
        @Expose
        val name: String? = null
)