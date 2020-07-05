package com.example.unittestingexample

import android.content.Context

class ShoppingCart{

    fun calculateAmount(price: Float, qty: Int): Float =
        when(qty){
            in (0..3)-> price * qty
            in (3..5)->  (price * qty * .90).toFloat()
            else -> (price * qty * .85).toFloat()
        }

    fun validateEmail(context: Context, email: String): Pair<Boolean, String> =
        if(email.indexOf("@") == -1){
            Pair(false, context.getString(R.string.error_valid_email))
        } else{
            Pair(true, context.getString(R.string.success_valid_email))
        }
}