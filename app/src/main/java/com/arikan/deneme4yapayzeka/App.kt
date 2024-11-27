package com.arikan.deneme4yapayzeka

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Hilt kullanıyorsan
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Gerekli başlatmalar burada yapılabilir
    }
}
