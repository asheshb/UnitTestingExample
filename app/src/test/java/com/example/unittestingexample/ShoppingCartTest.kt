package com.example.unittestingexample

import android.content.Context
import org.hamcrest.core.Is.`is`

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

private const val ERROR_VALID_EMAIL = "The email is not valid"
private const val SUCCESS_VALID_EMAIL = "The email validated successfully"


@RunWith(MockitoJUnitRunner::class)
class ShoppingCartTest{
    @Mock
    private lateinit var mockContext: Context

    private lateinit var shoppingCart: ShoppingCart

    @Before
    fun setup(){
        shoppingCart = ShoppingCart()
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

    @Test
    fun validateEmail_ValidEmail_ReturnsTrue(){
        `when`(mockContext.getString(R.string.success_valid_email))
            .thenReturn(SUCCESS_VALID_EMAIL)

        val(result, message) = shoppingCart.validateEmail(mockContext, "customer@example.com")
        assertTrue(result)
        assertThat(message, `is`(SUCCESS_VALID_EMAIL))
    }

    @Test
    fun validateEmail_InvalidEmail_ReturnsFalse(){
        `when`(mockContext.getString(R.string.error_valid_email))
            .thenReturn(ERROR_VALID_EMAIL)

        val(result, message) = shoppingCart.validateEmail(mockContext, "customerexample.com")
        assertFalse(result)
        assertThat(message, `is`(ERROR_VALID_EMAIL))
    }
}