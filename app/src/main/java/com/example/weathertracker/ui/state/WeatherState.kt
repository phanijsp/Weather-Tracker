package com.example.weathertracker.ui.state

import com.example.weathertracker.domain.model.Weather

sealed class WeatherState {
    data class Init(val weather: Weather?) : WeatherState()
    object Loading : WeatherState()
    data class Success(val weather: Weather) : WeatherState()
    data class Error(val message: String) : WeatherState()
}