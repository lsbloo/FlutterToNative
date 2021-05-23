package com.demo.demo_android.core.views


import androidx.appcompat.app.AppCompatActivity
import com.demo.demo_android.core.flutter.FlutterChannelManager
import com.demo.demo_android.core.flutter.FlutterCoreEngine


open class BaseActivity : AppCompatActivity() {
    companion object {
        var FLUTTER_ENGINER_START = false
    }

    var flutterChannelManager: FlutterChannelManager? = null

    fun getChannelManager(): FlutterChannelManager? {
        return if (!FLUTTER_ENGINER_START) {
            flutterChannelManager
        }else {
            flutterChannelManager = FlutterCoreEngine.channelManager
            flutterChannelManager
        }

    }

    fun initalRouter(initalRouter: String) {
        if (!FLUTTER_ENGINER_START) {
            FlutterCoreEngine.start(this)
            FlutterCoreEngine.navigator?.initalRouter(initalRouter, this)
            FLUTTER_ENGINER_START = true

        } else {
            FlutterCoreEngine.navigator?.initalRouter(initalRouter, this)
        }
    }

}