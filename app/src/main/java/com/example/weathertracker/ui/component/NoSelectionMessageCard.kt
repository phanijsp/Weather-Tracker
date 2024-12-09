package com.example.weathertracker.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
fun NoSelectionMessageCard(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "No City Selected",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily(Font(resId = R.font.comfortaa_bold))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Please Search For A City",
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily(Font(resId = R.font.comfortaa_bold))
        )
    }
}