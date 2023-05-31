package com.hmn.shared.data.model

import com.hmn.shared.data.vos.RestaurantVO

interface RestaurantModel {
    fun getRestaurantModel(
        onSuccess:(List<RestaurantVO>) ->Unit,
        onFailure:(String)->Unit
    )
}