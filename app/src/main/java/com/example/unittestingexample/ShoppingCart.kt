package com.example.unittestingexample

class ShoppingCart{

    fun calculateAmount(price: Float, qty: Int): Float =
        when(qty){
            in (0..3)-> price * qty
            in (3..5)->  (price * qty * .90).toFloat()
            else -> (price * qty * .85).toFloat()
        }

}