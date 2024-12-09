package com.example.weathertracker

import android.content.Context
import android.content.SharedPreferences
import com.example.weathertracker.data.api.WeatherApiService
import com.example.weathertracker.data.mapper.WeatherMapper
import com.example.weathertracker.data.preferences.CityPreferences
import com.example.weathertracker.data.repository.WeatherRepository
import com.example.weathertracker.data.repository.impl.WeatherRepositoryImpl
import com.example.weathertracker.domain.usecase.weather.GetWeatherUseCase
import com.example.weathertracker.ui.viewmodel.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(WeatherApiService::class.java)
    }

    single { WeatherMapper() }

    single<SharedPreferences> {
        get<Context>().getSharedPreferences("WeatherPreferences", Context.MODE_PRIVATE)
    }

    single { CityPreferences(get()) }

    single<WeatherRepository> { WeatherRepositoryImpl(
        "3dc9845fc05f433d8f3184344240912",get(), get(), get()
    ) }

    factory { GetWeatherUseCase(get()) }

    viewModel { WeatherViewModel(get()) }
}