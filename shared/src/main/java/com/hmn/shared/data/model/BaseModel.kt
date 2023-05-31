package com.hmn.shared.data.model

import com.hmn.shared.network.responses.BASE_URL_FOOD_PANDA
import com.hmn.shared.network.responses.RestaurantApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected lateinit var mRestaurantApi: RestaurantApi
    fun initRetrofitWithBaseUrl(baseUrl:String){
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mRestaurantApi = retrofit.create(RestaurantApi::class.java)
    }
}