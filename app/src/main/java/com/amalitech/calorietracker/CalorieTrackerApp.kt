package com.amalitech.calorietracker

import android.app.Application
import com.amalitech.calorietracker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CalorieTrackerApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CalorieTrackerApp)
            modules(appModule)
        }
    }

}