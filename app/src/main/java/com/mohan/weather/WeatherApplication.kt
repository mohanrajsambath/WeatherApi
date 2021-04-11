package com.mohan.weather

import android.app.Application
import com.mohan.weather.di.networkModule
import com.mohan.weather.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()

    }

    private fun configureDi() {
        startKoin {
            androidContext(this@WeatherApplication)
            androidLogger()
            modules(listOf(networkModule, viewModelModule))
        }
    }
}