package com.hmn.rider.activities

import android.app.PendingIntent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.hmn.rider.R
import com.hmn.rider.notification.NotificationTestTwo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pendingIntent = PendingIntent.getActivity(this,0,
            RestaurantDetailActivity.newIntent(this),PendingIntent.FLAG_IMMUTABLE)

        NotificationTestTwo.notifyMe(this@MainActivity,
            title = "Hello",
            body =getString(R.string.notiBody),
            pendingIntent =pendingIntent
            )

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            Log.d("firebase_token",it.result)
        }
        btnShowNotif.setOnClickListener {
           // NotificationTestTwo.notifyMe(this@MainActivity, title = "Hello", body =getString(R.string.notiBody) )

        }
    }
}