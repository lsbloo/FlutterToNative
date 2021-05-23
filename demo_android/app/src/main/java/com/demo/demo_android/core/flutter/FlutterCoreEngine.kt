package com.demo.demo_android.core.flutter

import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


object FlutterCoreEngine {
    const val ENGINE_CACHED_NAME = "engine_f"
    const val NAME_METHOD_CHANNEL = "TestChannel"
    private lateinit var flutterEngine: FlutterEngine

    var navigator: FlutterNavigatorManager? = null
    var channelManager: FlutterChannelManager? = null

    fun start(context: Context) {
        flutterEngine = FlutterEngine(context);
        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put(ENGINE_CACHED_NAME, flutterEngine)
        navigator = FlutterNavigatorManager(flutterEngine)
        channelManager = FlutterChannelManager(flutterEngine,NAME_METHOD_CHANNEL)
        channelManager?.init()
    }
}
