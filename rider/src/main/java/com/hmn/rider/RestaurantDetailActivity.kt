package com.hmn.rider

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RestaurantDetailActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context):Intent{
            return Intent(context,RestaurantDetailActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
    }
}