package com.example.weathertracker.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathertracker.ui.component.AutoCompleteView
import com.example.weathertracker.ui.component.ErrorCard
import com.example.weathertracker.ui.component.NoSelectionMessageCard
import com.example.weathertracker.ui.component.SearchBarWithHint
import com.example.weathertracker.ui.component.WeatherDetails
import com.example.weathertracker.ui.state.WeatherState
import com.example.weathertracker.ui.viewmodel.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun WeatherScreen() {

    val weatherViewModel: WeatherViewModel = koinViewModel()
    val weatherState by weatherViewModel.weatherState.collectAsState()
    var showNoSelectionMessage by remember { mutableStateOf(false) }
    val showAutoComplete by weatherViewModel.showAutCompleteView.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp
            )
        ) {
            SearchBarWithHint(weatherViewModel)
            if(showAutoComplete){
                AutoCompleteView(weatherViewModel)
            }
            Spacer(modifier = Modifier.height(24.dp))

            when (weatherState) {
                is WeatherState.Loading -> {
                    showNoSelectionMessage = false
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is WeatherState.Success -> {
                    val weather = (weatherState as WeatherState.Success).weather
                    var showWeatherDetailsExpanded by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier.clickable {
                            showWeatherDetailsExpanded = true
                            weatherViewModel.saveCity(weather.city)
                        }.animateContentSize()
                    ) {
                        WeatherDetails(weather = weather, showWeatherDetailsExpanded)
                    }
                }

                is WeatherState.Error -> {
                    val message = (weatherState as WeatherState.Error).message
                    ErrorCard(message)
                }

                is WeatherState.Init -> {
                    val weather = (weatherState as WeatherState.Init).weather
                    if (weather != null) {
                        showNoSelectionMessage = false
                        WeatherDetails(weather = weather, showExpanded = true)
                    } else {
                        showNoSelectionMessage = true
                    }
                }
            }
        }

        if (showNoSelectionMessage) {
            NoSelectionMessageCard()
        }
    }
}











