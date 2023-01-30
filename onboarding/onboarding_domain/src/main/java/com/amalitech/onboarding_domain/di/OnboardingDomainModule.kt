package com.amalitech.onboarding_domain.di

import com.amalitech.onboarding_domain.use_case.ValidateNutrients
import org.koin.dsl.module

object OnboardingDomainModule {

    val module = module {
        single { ValidateNutrients() }
    }

}