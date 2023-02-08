package com.amalitech.tracker_data.di

import androidx.room.Room
import com.amalitech.tracker_data.local.TrackerDao
import com.amalitech.tracker_data.local.TrackerDatabase
import com.amalitech.tracker_data.remote.OpenFoodApi
import com.amalitech.tracker_data.repository.TrackerRepositoryImpl
import com.amalitech.tracker_domain.repository.TrackerRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object TrackerDataModule {
    val module = module {
        //provide and okhttp client
        single<OkHttpClient> {
            OkHttpClient().newBuilder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .build()
        }

        // api interface
        single<OpenFoodApi> {
            Retrofit.Builder()
                .baseUrl(OpenFoodApi.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(get())
                .build()
                .create()
        }

        // Tracker Dao
        single<TrackerDao> {
            Room.databaseBuilder(
                androidApplication(),
                TrackerDatabase::class.java,
                "tracker_db"
            ).build().dao
        }

        // repository
        single<TrackerRepository> {
            TrackerRepositoryImpl(get(), get())
        }
    }
}