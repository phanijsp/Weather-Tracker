package com.example.weathertracker.data.repository

import com.example.weathertracker.data.model.Location
import com.example.weathertracker.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: String): Weather
    suspend fun getSavedCity(): String?
    suspend fun saveCity(city: String)
    suspend fun getAutoCompleteLocations(query: String): List<Location>
}