package com.demo.demo_android.home.presenter


import android.util.Log
import com.demo.demo_android.core.flutter.FlutterChannelManager
import com.demo.demo_android.home.contract.HomeContract


class HomePresenterImpl(
    private val view: HomeContract.HomeView,
) : HomeContract.HomePresenter {


    override fun callMethodChannel() {
        view.getChannel()?.get()?.setMethodCallHandler { call, result ->
            Log.d("FluterModule", call.method)
            result.success(null)
        }
    }

    override fun init() {

    }

    override fun dispose() {

    }
}