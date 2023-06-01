package com.hmn.buildconfig.activities

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hmn.buildconfig.BuildConfig
import com.hmn.buildconfig.R
import com.hmn.buildconfig.adapters.RestaurantAdapter
import com.hmn.shared.data.vos.RestaurantVO
import com.hmn.shared.mvp.presenters.MainPresenter
import com.hmn.shared.mvp.presenters.MainPresenterImpl
import com.hmn.shared.mvp.views.MainView
import com.hmn.shared.showSnackBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private var mAdapter: RestaurantAdapter = RestaurantAdapter()
    lateinit var mPresenter: MainPresenter
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendNotification(this,"body","ffeeeee")
         setUpToolBar()
        setUpPresenter()
        setRecyclerView()
        mPresenter.onUiReady()

    }

    private fun setUpToolBar(){
        setSupportActionBar(mToolBar)
        supportActionBar?.title = "Welcome to ${getString(R.string.app_name)}"
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setRecyclerView() {
        with(rvMain) {
            rvMain.adapter = mAdapter
            rvMain.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun showRestaurant(restaurants: List<RestaurantVO>) {
        mAdapter.setNewData(restaurants)
    }

    override fun showError(errorMessage: String) {
        showSnackBar(errorMessage)
    }



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

        val notiBuilder = NotificationCompat.Builder(context)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText("content")


        val notification = buildNotification(context, NOTIFICATION_CHANNEL_ID, title, body)
        notificationManager.notify(0, notification)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun buildNotification(
        context: Context,
        title: String,
        channelId: String,
        content: String
    ): Notification {
        // Message in bigText style
        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.bigText(content)
        return NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(content)
            .setAutoCancel(true)
            .setStyle(bigTextStyle)
            .setAutoCancel(true)
            .build()
    }

    private fun getUniqueId() = ((System.currentTimeMillis() % 10000).toInt())
}