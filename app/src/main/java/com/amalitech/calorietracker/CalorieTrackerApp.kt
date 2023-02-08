package com.amalitech.calorietracker

import android.app.Application
import com.amalitech.calorietracker.di.appModule
import com.amalitech.onboarding_domain.di.OnboardingDomainModule
import com.amalitech.tracker_data.di.TrackerDataModule
import com.amalitech.tracker_domain.di.TrackerDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CalorieTrackerApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CalorieTrackerApp)
            modules(
                OnboardingDomainModule.module,
                TrackerDataModule.module,
                TrackerDomainModule.module,
                appModule
            )
        }
    }

}