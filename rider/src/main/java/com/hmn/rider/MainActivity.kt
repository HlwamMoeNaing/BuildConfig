package com.hmn.rider

import android.app.PendingIntent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.hmn.shared.showSnackBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pendingIntent = PendingIntent.getActivity(this,0,RestaurantDetailActivity.newIntent(this),PendingIntent.FLAG_IMMUTABLE)
        NotificationTestTwo.notifyMe(this@MainActivity,
            title = "Hello",
            body =getString(R.string.notiBody),
            pendingIntent =pendingIntent
            )

        btnShowNotif.setOnClickListener {
           // NotificationTestTwo.notifyMe(this@MainActivity, title = "Hello", body =getString(R.string.notiBody) )
        }
    }
}