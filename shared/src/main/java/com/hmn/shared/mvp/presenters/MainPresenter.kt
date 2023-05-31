package com.hmn.shared.mvp.presenters

import android.view.View
import com.hmn.shared.mvp.views.MainView

interface MainPresenter {
    fun initPresenter(view:MainView)
    fun onUiReady()
}