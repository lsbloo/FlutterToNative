package com.demo.demo_android.core.flutter

import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class FlutterChannelManager(private val flutterEngine: FlutterEngine, private val methodChannelManager: String) : ChannelManager {
    private lateinit var methodChannel: MethodChannel

    override fun init(){
        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, methodChannelManager)
    }

    override fun get() = methodChannel


}