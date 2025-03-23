package com.example.saude_sem_fronteiras

import android.app.Application
import com.example.saude_sem_fronteiras.di.AppContextProvider

class SaudeSemFronteirasApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContextProvider.init(this)
    }
}