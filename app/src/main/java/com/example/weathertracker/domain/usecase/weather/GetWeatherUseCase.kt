package com.example.weathertracker.domain.usecase.weather

import com.example.weathertracker.data.model.Location
import com.example.weathertracker.data.repository.WeatherRepository
import com.example.weathertracker.domain.model.Weather

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(city: String): Weather {
        return weatherRepository.getWeather(city)
    }

    suspend fun loadSavedCity(): String? {
        return weatherRepository.getSavedCity()
    }

    suspend fun saveCity(city: String){
        weatherRepository.saveCity(city)
    }

    suspend fun getAutoCompleteResults(query: String): List<Location>{
        return weatherRepository.getAutoCompleteLocations(query)
    }
}