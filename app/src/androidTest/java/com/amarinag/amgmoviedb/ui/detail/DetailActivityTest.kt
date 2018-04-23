package com.amarinag.amgmoviedb.ui.detail

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.view.View
import android.view.ViewGroup
import com.amarinag.amgmoviedb.R
import junit.framework.Assert.assertTrue
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * AMGMovieDB.
 *
 * @author -   AMarinaG
 * @since -   23/4/18
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<DetailActivity> = object : ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation()
                    .targetContext
            val result = Intent(targetContext, DetailActivity::class.java)
            result.putExtra(DetailActivity.EXTRA_MOVIE_ID, 269149L)
            return result
        }
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        IdlingRegistry.getInstance().register(mActivityTestRule.activity.getIdlingResource())
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        IdlingRegistry.getInstance()
                .unregister(mActivityTestRule.activity.getIdlingResource())
    }

    @Test
    fun detailLoad_success() {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        val textView = onView(
                allOf<View>(
                        withId(R.id.tv_overview),
                        withText(
                                "Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf<View>(
                                                android.widget.FrameLayout::class.java),
                                        0),
                                1),
                        isDisplayed()))
        textView.check(
                matches(
                        withText(
                                "Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.")))

        assertTrue(true)
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (parent is ViewGroup
                        && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position))
            }
        }
    }
}