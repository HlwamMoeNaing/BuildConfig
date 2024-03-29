package com.hmn.rider

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService

@RequiresApi(Build.VERSION_CODES.O)
fun sendNotification(context: Context, body: String, title: String) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val NOTIFICATION_CHANNEL_ID = BuildConfig.APPLICATION_ID + ".channel"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = context.getString(R.string.app_name)
        val channel =
            NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
              name,
                NotificationManager.IMPORTANCE_DEFAULT
            )
        notificationManager.createNotificationChannel(channel)
    }
    val notification = buildNotification(context,NOTIFICATION_CHANNEL_ID,title,body)
    notificationManager.notify(getUniqueId(),notification)


}

@RequiresApi(Build.VERSION_CODES.O)
private fun buildNotification(
    context: Context,
    title: String,
    channelId: String,
    content: String
): Notification {
    // Message in bigText style
    val bigTextStyle = Notification.BigTextStyle()
    bigTextStyle.bigText(content)
    return Notification.Builder(context, channelId)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle(title)
        .setContentText(content)
        .setAutoCancel(true)
        .setStyle(bigTextStyle)
        .build()

}

private fun getUniqueId() = ((System.currentTimeMillis() % 10000).toInt())