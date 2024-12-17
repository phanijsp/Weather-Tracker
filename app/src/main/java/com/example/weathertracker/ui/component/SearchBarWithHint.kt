package com.example.weathertracker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.weathertracker.R
import com.example.weathertracker.ui.viewmodel.WeatherViewModel


@Composable
fun SearchBarWithHint(weatherViewModel: WeatherViewModel) {

    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,

        onValueChange = {
            query = it
            weatherViewModel.getAutoCompleteResults(query)
                        },
        placeholder = {
            Text(
                text = "Search Location", color = colorResource(R.color.search_bar_text),
                style = TextStyle(
                    fontFamily = FontFamily(Font(resId = R.font.comfortaa_regular))
                ),
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.baseline_search_24),
                contentDescription = "Search",
                tint = colorResource(R.color.search_bar_text),
                modifier = Modifier.clickable {
                    weatherViewModel.loadWeather(query)
                }
            )
        },
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.search_bar_bg),
            unfocusedContainerColor = colorResource(R.color.search_bar_bg),
            disabledContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(resId = R.font.comfortaa_regular))
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                weatherViewModel.loadWeather(query)
            }
        )
    )
}