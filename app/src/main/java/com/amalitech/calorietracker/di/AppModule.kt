package com.amalitech.calorietracker.di

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.amalitech.core.data.preferences.DefaultPreferences
import com.amalitech.core.domain.preferences.Preferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> {
        androidApplication().getSharedPreferences("shared_pref", MODE_PRIVATE)
    }
    single<Preferences> {
        DefaultPreferences(get())
    }

}