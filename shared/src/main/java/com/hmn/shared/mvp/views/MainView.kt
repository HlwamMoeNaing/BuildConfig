package com.hmn.shared.mvp.views

import com.hmn.shared.data.vos.RestaurantVO

interface MainView {
    fun showRestaurant(restaurants:List<RestaurantVO>)
    fun showError(errorMessage:String)
}