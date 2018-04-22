package com.amarinag.amgmoviedb.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   22/4/18
 */
data class ProductionCompany(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("logo_path")
        @Expose
        val logoPath: String? = null,
        @SerializedName("name")
        @Expose
        val name: String? = null,
        @SerializedName("origin_country")
        @Expose
        val originCountry: String? = null
)
