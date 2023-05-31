package com.hmn.shared.data.model

import com.hmn.shared.data.vos.RestaurantVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object RestaurantModelImpl : RestaurantModel, BaseModel() {
    override fun getRestaurantModel(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mRestaurantApi.getRestaurants()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.data ?: listOf())
            }, {
                onFailure(it.localizedMessage ?: "Not Interner Connection")
            })
    }
}