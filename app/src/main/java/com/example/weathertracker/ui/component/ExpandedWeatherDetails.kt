package com.example.weathertracker.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weathertracker.R
import com.example.weathertracker.domain.model.Weather

@Composable
fun ExpandedWeatherDetails(weather: Weather){
    Column(
        modifier = Modifier.fillMaxSize().animateContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https:${weather.weatherIconUrl
                    .replace("64x64", "128x128")}",
                contentDescription = "Weather Icon",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = weather.city, style = MaterialTheme.typography.titleLarge, fontFamily = FontFamily(
                Font(resId = R.font.comfortaa_bold)
            )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(text = weather.temperatureCelsius.toString(), style = MaterialTheme.typography.displayLarge, fontFamily = FontFamily(
                    Font(resId = R.font.comfortaa_bold)
                )
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = "o", style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.height(24.dp))

        }
        Box(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            WeatherItemsCard(weather)
        }
    }

}