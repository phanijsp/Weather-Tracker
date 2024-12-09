package com.example.weathertracker.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weathertracker.R
import com.example.weathertracker.domain.model.Weather


@Composable
fun WeatherDetails(weather: Weather, showExpanded: Boolean = false){

    if(showExpanded){
        ExpandedWeatherDetails(weather)
    }else{
        Row(
            modifier = Modifier.fillMaxWidth()
                .animateContentSize()
                .clip(MaterialTheme.shapes.large)
                .background(colorResource(R.color.search_bar_bg))
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = weather.city, style = MaterialTheme.typography.titleLarge, fontFamily = FontFamily(
                    Font(resId = R.font.comfortaa_bold)
                )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text = weather.temperatureCelsius.toString(), style = MaterialTheme.typography.displayLarge, fontFamily = FontFamily(
                        Font(resId = R.font.comfortaa_bold)
                    )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "o", style = MaterialTheme.typography.labelSmall)
                }
            }

            AsyncImage(
                model = "https:${weather.weatherIconUrl
                    .replace("64x64", "128x128")}",
                contentDescription = "Translated description of what the image contains",
                modifier = Modifier.fillMaxHeight()
            )

        }
    }

}