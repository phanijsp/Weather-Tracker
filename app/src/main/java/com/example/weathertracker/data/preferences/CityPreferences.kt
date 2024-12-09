package com.example.weathertracker.data.preferences

import android.content.SharedPreferences

class CityPreferences(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val CITY_KEY = "city_key"
    }

    fun saveCity(city: String) {
        sharedPreferences.edit().putString(CITY_KEY, city).apply()
    }

    fun getSavedCity(): String? {
        return sharedPreferences.getString(CITY_KEY, null)
    }
}