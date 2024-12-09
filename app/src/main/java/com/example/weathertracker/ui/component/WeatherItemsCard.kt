package com.example.weathertracker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.weathertracker.R
import com.example.weathertracker.domain.model.Weather

@Composable
fun WeatherItemsCard(weather: Weather){
    Row(modifier = Modifier.fillMaxWidth()
        .clip(MaterialTheme.shapes.large)
        .background(colorResource(R.color.search_bar_bg))
        .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {

        WeatherTextPairItem("Humidity", weather.humidity.toString()+"%")
        WeatherTextPairItem("UV", weather.uv.toString())
        WeatherTextPairItem("Feels Like", weather.feelsLikeCelsius.toString(), showDegree = true)

    }
}