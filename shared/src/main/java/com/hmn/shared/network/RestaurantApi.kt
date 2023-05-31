package com.hmn.shared.network.responses

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RestaurantApi {
    @GET(END_POINT_GET_FOOD)
    fun getRestaurants():Observable<GetRestaurantResponse>
}