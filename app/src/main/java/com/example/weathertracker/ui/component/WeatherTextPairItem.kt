package com.example.weathertracker.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.weathertracker.R

@Composable
fun WeatherTextPairItem(heading: String, value: String, showDegree: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = heading, style = MaterialTheme.typography.labelSmall, fontFamily = FontFamily(
                Font(resId = R.font.comfortaa_regular)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = value, style = MaterialTheme.typography.labelLarge, fontFamily = FontFamily(
                    Font(resId = R.font.comfortaa_regular)
                )
            )
            if (showDegree) {
                Text(text = "°", style = MaterialTheme.typography.labelSmall)
            }
        }
    }

}