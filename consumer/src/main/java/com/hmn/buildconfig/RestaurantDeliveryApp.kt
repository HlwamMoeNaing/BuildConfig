package com.hmn.buildconfig

import android.app.Application
import com.hmn.shared.data.model.RestaurantModelImpl

class RestaurantDeliveryApp:Application() {
    override fun onCreate() {
        super.onCreate()
        RestaurantModelImpl.initRetrofitWithBaseUrl(BuildConfig.ENDPINT)
    }
}