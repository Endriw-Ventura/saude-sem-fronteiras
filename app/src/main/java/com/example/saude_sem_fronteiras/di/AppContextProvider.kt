package com.example.saude_sem_fronteiras.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

@SuppressLint("StaticFieldLeak")
object AppContextProvider {
    lateinit var context: Context
        private set

    fun init(application: Application) {
        context = application.applicationContext
    }
}