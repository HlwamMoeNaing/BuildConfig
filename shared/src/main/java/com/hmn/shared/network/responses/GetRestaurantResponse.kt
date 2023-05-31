package com.hmn.shared.network.responses

import com.google.gson.annotations.SerializedName
import com.hmn.shared.data.vos.RestaurantVO

class GetRestaurantResponse(
    @SerializedName("code")
    val code:Int?,

    @SerializedName("message")
    val message:String?,
    @SerializedName("data")
    val data:List<RestaurantVO>?
)