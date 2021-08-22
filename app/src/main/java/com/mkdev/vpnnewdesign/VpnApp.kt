package com.mkdev.vpnnewdesign

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class VpnApp:Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}