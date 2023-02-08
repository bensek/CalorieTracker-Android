package com.amalitech.tracker_domain.use_case

import com.amalitech.tracker_domain.model.TrackableFood
import com.amalitech.tracker_domain.model.TrackedFood
import com.amalitech.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFoodUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
       return repository.deleteTrackedFood(trackedFood)
    }
}