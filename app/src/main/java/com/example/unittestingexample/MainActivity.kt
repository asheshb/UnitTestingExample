package com.example.unittestingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_amount.setOnClickListener{
            product_error_message.visibility = View.INVISIBLE

            val productQtyText = product_qty.text.toString()
            if(productQtyText.isEmpty()){
                product_error_message.visibility = View.VISIBLE
            } else{
                val qty:Int = productQtyText.toInt()
                if(qty == 0){
                    product_error_message.visibility = View.VISIBLE
                } else{
                    val price = product_price.text.toString().toFloat()
                    val amount = ShoppingCart().calculateAmount(price, qty)
                    product_amount.text = amount.toString()
                }
            }
        }
    }
}