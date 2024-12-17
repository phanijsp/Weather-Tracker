package com.example.weathertracker.data.repository.impl

import android.util.Log
import com.example.weathertracker.data.api.WeatherApiService
import com.example.weathertracker.data.mapper.WeatherMapper
import com.example.weathertracker.data.model.Location
import com.example.weathertracker.data.preferences.CityPreferences
import com.example.weathertracker.data.repository.WeatherRepository
import com.example.weathertracker.domain.model.Weather
import retrofit2.HttpException
import java.io.IOException

class WeatherRepositoryImpl(
    private val weatherApiKey: String,
    private val weatherApiService: WeatherApiService,
    private val weatherMapper: WeatherMapper,
    private val cityPreferences: CityPreferences
) : WeatherRepository {

    override suspend fun getWeather(city: String): Weather {
        return try {

            val response = weatherApiService.getCurrentWeather(weatherApiKey, city)
            weatherMapper.toDomain(response)

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("WeatherRepository", "HTTP error: ${e.code()} - $errorBody")
            throw Exception("Unable to fetch weather data. Error code: ${e.code()}")
        } catch (e: IOException) {
            Log.e("WeatherRepository", "Network error: ${e.message}")
            throw Exception("Network error. Please check your internet connection.")
        } catch (e: Exception) {
            Log.e("WeatherRepository", "Unexpected error: ${e.message}")
            throw Exception("An unexpected error occurred: ${e.message}")
        }
    }

    override suspend fun getSavedCity(): String? {
        return cityPreferences.getSavedCity()
    }

    override suspend fun saveCity(city: String) {
        cityPreferences.saveCity(city)
    }

    override suspend fun getAutoCompleteLocations(query: String): List<Location> {
        return try {
            weatherApiService.getAutoCompleteResults(weatherApiKey, query)
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("WeatherRepository", "HTTP error: ${e.code()} - $errorBody")
            throw Exception("Unable to fetch weather data. Error code: ${e.code()}")
        } catch (e: IOException) {
            Log.e("WeatherRepository", "Network error: ${e.message}")
            throw Exception("Network error. Please check your internet connection.")
        } catch (e: Exception) {
            Log.e("WeatherRepository", "Unexpected error: ${e.message}")
            throw Exception("An unexpected error occurred: ${e.message}")
        }
    }
}