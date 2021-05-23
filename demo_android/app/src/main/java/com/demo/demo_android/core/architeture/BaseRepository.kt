package com.demo.demo_android.core.architeture

import io.reactivex.disposables.CompositeDisposable

interface BaseRepository {
    fun <T> attachListener(t: T)
    fun getDisposable(): CompositeDisposable
}