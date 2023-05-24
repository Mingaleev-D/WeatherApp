package com.example.weatherapp.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.common.formatDateTime
import com.example.weatherapp.data.model.WeatherItem

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

@Composable fun SunsetSunRiseRow(weather: WeatherItem) {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(top = 15.dp, bottom = 15.dp),
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically
   ) {
      Row {
         Image(
             painter = painterResource(id = R.drawable.sunrise),
             contentDescription = null,
             modifier = Modifier.size(30.dp)
         )
         Text(text = formatDateTime(weather.sunrise), style = MaterialTheme.typography.caption)
      }
      Row {
         Image(
             painter = painterResource(id = R.drawable.sunset),
             contentDescription = null,
             modifier = Modifier.size(30.dp)
         )
         Text(text = formatDateTime(weather.sunset), style = MaterialTheme.typography.caption)
      }
   }
}