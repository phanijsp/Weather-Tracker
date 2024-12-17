package com.example.weathertracker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.weathertracker.ui.viewmodel.WeatherViewModel

@Composable
fun AutoCompleteView(weatherViewModel: WeatherViewModel) {
    val autoCompleteResults by weatherViewModel.autoCompleteResults.collectAsState()
    LazyColumn {
        items(autoCompleteResults){location->
            Card(
                modifier = Modifier.fillMaxWidth().clickable {
                    weatherViewModel.loadWeather(location.name)
                }
            ) {
                Text(text = location.name)
            }
        }
    }
}