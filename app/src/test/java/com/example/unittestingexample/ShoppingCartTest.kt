package com.example.unittestingexample

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ShoppingCartTest{
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

}