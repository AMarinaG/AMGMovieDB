package com.amarinag.amgmoviedb.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   19/4/18
 */
data class Popular(
        @SerializedName("page")
        @Expose
        val page: Int = 0,
        @SerializedName("total_results")
        @Expose
        val totalResults: Int = 0,
        @SerializedName("total_pages")
        @Expose
        val totalPages: Int = 0,
        @SerializedName("results")
        @Expose
        val results: List<Movie>? = null
)
