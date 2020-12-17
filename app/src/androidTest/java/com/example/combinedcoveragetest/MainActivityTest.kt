package com.example.combinedcoveragetest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageButton = onView(
            allOf(withContentDescription("Open navigation drawer"), isDisplayed())
        )
        appCompatImageButton.perform(click())

        val navigationMenuItemView = onView(
            allOf(withId(R.id.nav_gallery), isDisplayed())
        )
        navigationMenuItemView.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.text_gallery), withText("This is gallery Fragment"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("This is gallery Fragment")))
    }
}
