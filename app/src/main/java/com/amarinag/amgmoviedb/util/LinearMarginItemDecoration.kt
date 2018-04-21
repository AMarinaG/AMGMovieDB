package com.amarinag.amgmoviedb.util

import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *      AMGMovieDB.
 *
 *  @author -   AMarinaG
 *  @since  -   21/4/18
 */
class LinearMarginItemDecoration(private val margin: Int, private val orientation: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.right = margin
        } else {
            outRect.bottom = margin / 2
            outRect.top = margin / 2
        }
    }
}
