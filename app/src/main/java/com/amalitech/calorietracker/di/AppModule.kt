package com.amalitech.calorietracker.di

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.amalitech.core.data.preferences.DefaultPreferences
import com.amalitech.core.domain.preferences.Preferences
import com.amalitech.core.domain.use_case.FilterOutDigits
import com.amalitech.onboarding_presentation.activity.ActivityViewModel
import com.amalitech.onboarding_presentation.age.AgeViewModel
import com.amalitech.onboarding_presentation.gender.GenderViewModel
import com.amalitech.onboarding_presentation.goal.GoalViewModel
import com.amalitech.onboarding_presentation.height.HeightViewModel
import com.amalitech.onboarding_presentation.nutrient_goal.NutrientGoalViewModel
import com.amalitech.onboarding_presentation.weight.WeightViewModel
import com.amalitech.tracker_presentation.tracker_overview.TrackerOverviewViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> {
        androidApplication().getSharedPreferences("shared_pref", MODE_PRIVATE)
    }
    single<Preferences> {
        DefaultPreferences(get())
    }
    single { FilterOutDigits() }

    viewModel { GenderViewModel(get()) }
    viewModel { AgeViewModel(get(), get()) }
    viewModel { WeightViewModel(get()) }
    viewModel { HeightViewModel(get(), get()) }
    viewModel { ActivityViewModel(get()) }
    viewModel { GoalViewModel(get()) }
    viewModel { NutrientGoalViewModel(get(), get(), get()) }
    viewModel { TrackerOverviewViewModel(get(), get()) }
}