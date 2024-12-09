package com.example.weathertracker.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertracker.domain.usecase.weather.GetWeatherUseCase
import com.example.weathertracker.ui.state.WeatherState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val tag = WeatherViewModel::class.simpleName

    private val _weatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val weatherState: StateFlow<WeatherState> get() = _weatherState

    init {
        viewModelScope.launch {
            val savedCity = getWeatherUseCase.loadSavedCity()
            if(savedCity!=null){
                try {
                    val weather = getWeatherUseCase(savedCity)
                    _weatherState.value = WeatherState.Init(weather)
                } catch (e: Exception) {
                    _weatherState.value = WeatherState.Error(e.message ?: "Unknown error")
                }
            }else{
                _weatherState.value = WeatherState.Init(null)
            }
        }
    }

    fun loadWeather(city: String) {
        _weatherState.value = WeatherState.Loading
        viewModelScope.launch {
            try {
                val weather = getWeatherUseCase(city)
                _weatherState.value = WeatherState.Success(weather)
            } catch (e: Exception) {
                _weatherState.value = WeatherState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun saveCity(city: String){
        viewModelScope.launch {
            try {
                getWeatherUseCase.saveCity(city)
            }catch (e: Exception){
                Log.e(tag, "saveCity: ", e)
            }
        }
    }
}