package com.example.weathertracker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.weathertracker.R

@Composable
fun ErrorCard(message: String){
    Row(
        modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.large)
            .background(colorResource(R.color.search_bar_bg)).padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painterResource(R.drawable.baseline_error_24),
            contentDescription = "Error",
            tint = Color.Red,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = message,
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily(Font(resId = R.font.comfortaa_bold))
        )

    }
}