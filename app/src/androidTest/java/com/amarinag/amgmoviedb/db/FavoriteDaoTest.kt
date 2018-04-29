package com.amarinag.amgmoviedb.db

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.amarinag.amgmoviedb.model.Favorite
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertNotNull

/**
 * AMGMovieDB.
 *
 * @author -   AMarinaG
 * @since -   29/4/18
 */
@RunWith(AndroidJUnit4::class)
class FavoriteDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun addFavoriteAndGetFavorite() {
        database.favoriteDao().addFavorite(FAVORITE)

        val favorite = database.favoriteDao().getFavoriteById(FAVORITE.movieId)
        assertNotNull(favorite, "Not Null Required!")
        assert(favorite?.movieId == FAVORITE.movieId)
        assert(favorite?.isFavorite == FAVORITE.isFavorite)
    }

    companion object {
        private val FAVORITE = Favorite(1, true)
    }
}