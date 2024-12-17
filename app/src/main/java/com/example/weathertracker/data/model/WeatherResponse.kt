package com.example.weathertracker.data.model

data class WeatherResponse(
    val location: Location,
    val current: Current
)



data class Current(
    val temp_c: Double,
    val condition: Condition,
    val humidity: Int,
    val feelslike_c: Double,
    val uv: Double
)

data class Condition(
    val icon: String
)
