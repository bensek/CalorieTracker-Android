package com.amalitech.calorietracker.navigation

import androidx.navigation.NavController
import com.amalitech.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}