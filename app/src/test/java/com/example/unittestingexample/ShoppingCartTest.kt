package com.example.unittestingexample

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk =  [Build.VERSION_CODES.P])
class ShoppingCartTest{
    private lateinit var shoppingCart: ShoppingCart

    @Before
    fun setup(){
        shoppingCart = ShoppingCart()
    }

    @Test
    fun validateEmail_ValidEmail_ReturnsTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val(result, message) = shoppingCart.validateEmail(context, "customer@example.com")
        assertTrue(result)
    }

    @Test
    fun validateEmail_InvalidEmail_ReturnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val(result, message) = shoppingCart.validateEmail(context, "customerexample.com")
        assertFalse(result)
    }

    @Test
    fun calculateAmount_PriceQty_ReturnsNoDiscountAmount(){
        assertEquals(5000F, shoppingCart.calculateAmount(2500F, 2))
    }

    @Test
    fun calculateAmount_PriceQty_ReturnsTenPercentDiscountAmount(){
        assertEquals(9000F, shoppingCart.calculateAmount(2500F, 4))
    }

    @Test
    fun calculateAmount_PriceQty_ReturnsFifteenPercentDiscountAmount(){
        assertEquals(12750F, shoppingCart.calculateAmount(2500F, 6))
    }
}