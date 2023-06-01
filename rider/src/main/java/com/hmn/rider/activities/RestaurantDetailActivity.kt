package com.hmn.rider.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hmn.rider.R

class RestaurantDetailActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context):Intent{
            return Intent(context, RestaurantDetailActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
    }
}