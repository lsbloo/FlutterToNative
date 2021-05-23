package com.demo.demo_android.core.architeture

import com.demo.demo_android.core.flutter.FlutterChannelManager


interface BaseView {

    fun getChannel(): FlutterChannelManager?

    fun finishActivie()

    fun initComponents()
}