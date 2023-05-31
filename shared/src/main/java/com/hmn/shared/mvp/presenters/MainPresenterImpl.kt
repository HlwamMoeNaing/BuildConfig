package com.hmn.shared.mvp.presenters

import android.view.View
import androidx.lifecycle.ViewModel
import com.hmn.shared.data.model.RestaurantModelImpl
import com.hmn.shared.mvp.views.MainView

class MainPresenterImpl : MainPresenter, ViewModel() {
    var mView: MainView? = null

    private val mModel: RestaurantModelImpl = RestaurantModelImpl
    override fun initPresenter(view: MainView) {
        mView = view
    }


    override fun onUiReady() {
        mModel.getRestaurantModel(
            onSuccess = { mView?.showRestaurant(it) },
            onFailure = { mView?.showError(it) }
        )
    }
}