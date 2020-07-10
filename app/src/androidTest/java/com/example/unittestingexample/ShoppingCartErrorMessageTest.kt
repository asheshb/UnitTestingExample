package com.example.unittestingexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.IsNot.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ShoppingCartErrorMessageTest{
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

        @Test
        fun calculateAmount_ShowErrorMessage(){
            onView(withId(R.id.product_qty)).perform(typeText(""))
            onView(withId(R.id.calculate_amount)).perform(click())
            onView(withId(R.id.product_error_message)).check(matches(isDisplayed()))
        }

    @Test
    fun calculateAmount_NotShowErrorMessage(){
        onView(withId(R.id.product_qty)).perform(typeText("4"))
        onView(withId(R.id.calculate_amount)).perform(click())
        onView(withId(R.id.product_error_message)).check(matches(not(isDisplayed())))
    }
}