package com.luka.travel

import android.app.Application
import com.luka.travel.utils.Release
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        } else {
            plant(
                Release()
            )
        }
    }
}
