package com.demo.demo_android.core.flutter

import io.flutter.plugin.common.MethodChannel

interface ChannelManager {
    fun init()
    fun get(): MethodChannel
}