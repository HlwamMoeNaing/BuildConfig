package com.hmn.buildconfig.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}