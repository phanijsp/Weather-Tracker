package com.example.weathertracker.data.mapper

import com.example.weathertracker.data.model.WeatherResponse
import com.example.weathertracker.domain.model.Weather


class WeatherMapper {
    fun toDomain(response: WeatherResponse): Weather {
        return Weather(
            city = response.location.name,
            country = response.location.country,
            temperatureCelsius = response.current.temp_c,
            feelsLikeCelsius = response.current.feelslike_c,
            weatherIconUrl = response.current.condition.icon,
            humidity = response.current.humidity,
            uv = response.current.uv.toInt(),
        )
    }
}