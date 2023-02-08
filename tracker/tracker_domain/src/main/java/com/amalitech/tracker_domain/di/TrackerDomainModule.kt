package com.amalitech.tracker_domain.di

import androidx.lifecycle.ViewModel
import com.amalitech.tracker_domain.use_case.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object TrackerDomainModule {

    val module= module {
        scope<ViewModel> {
            scoped <TrackerUseCases> {
                TrackerUseCases(
                    trackFoodUseCase = TrackFoodUseCase(get()),
                    searchFoodUseCase = SearchFoodUseCase(get()),
                    getFoodsForDateUseCase = GetFoodsForDateUseCase(get()),
                    deleteTrackedFoodUseCase = DeleteTrackedFoodUseCase(get()),
                    calculateMealNutrientsUseCase = CalculateMealNutrientsUseCase(get())
                )
            }
        }
    }
}