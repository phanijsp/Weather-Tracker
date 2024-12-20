package com.example.weathertracker.data.api

import com.example.weathertracker.data.model.Location
import com.example.weathertracker.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String
    ): WeatherResponse

    @GET("search.json")
    suspend fun getAutoCompleteResults(
        @Query("key") apiKey: String,
        @Query("q") text: String
    ): List<Location>
}