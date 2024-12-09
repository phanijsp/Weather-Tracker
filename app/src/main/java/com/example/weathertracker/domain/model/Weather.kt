package com.example.weathertracker.domain.model

data class Weather(
    val city: String,
    val country: String,
    val temperatureCelsius: Double,
    val feelsLikeCelsius: Double,
    val weatherIconUrl: String,
    val humidity: Int,
    val uv: Int,
)