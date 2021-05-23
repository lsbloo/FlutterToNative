package com.demo.demo_android.core.flutter

import android.content.Context

interface NavigatorManager {
    fun callRouter(router: String, context: Context?)
}