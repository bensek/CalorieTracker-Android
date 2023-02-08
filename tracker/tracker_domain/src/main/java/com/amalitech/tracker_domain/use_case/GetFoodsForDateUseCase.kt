package com.amalitech.tracker_domain.use_case

import com.amalitech.tracker_domain.model.TrackableFood
import com.amalitech.tracker_domain.model.TrackedFood
import com.amalitech.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDateUseCase(
    private val repository: TrackerRepository
) {
    operator fun invoke(
        date: LocalDate
    ): Flow<List<TrackedFood>> {
       return repository.getFoodsForDate(date)
    }
}