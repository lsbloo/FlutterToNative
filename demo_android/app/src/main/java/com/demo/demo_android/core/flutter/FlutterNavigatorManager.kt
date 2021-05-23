package com.demo.demo_android.core.flutter

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class FlutterNavigatorManager(private val engine: FlutterEngine) : NavigatorManager {
    override fun callRouter(router: String, ctx: Context?) {
        ctx?.let {
            engine.navigationChannel.pushRoute(router)
            val intent =
                FlutterActivity.withCachedEngine(FlutterCoreEngine.ENGINE_CACHED_NAME).build(it)
            it.startActivity(intent)
        }
    }
}