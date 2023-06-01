package com.hmn.rider.notification

import android.app.PendingIntent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.hmn.rider.activities.RestaurantDetailActivity

class FCMService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("firebase_tiken", token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
       // Log.d("@message",message.data)
        NotificationTestTwo.notifyMe(
            this,
            title = message.notification?.title?: "",
            body =message.notification?.body ?: "",
            pendingIntent = PendingIntent.getActivity(
                this,
                0,
                RestaurantDetailActivity.newIntent(this),
                PendingIntent.FLAG_IMMUTABLE
            )
        )
    }
}