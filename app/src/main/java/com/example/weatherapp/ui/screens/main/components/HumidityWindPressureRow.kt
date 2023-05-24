package com.example.weatherapp.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherItem

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

@Composable fun HumidityWindPressureRow(weather: WeatherItem) {
   Row(
       modifier = Modifier
           .padding(12.dp)
           .fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceBetween
   ) {
      Row(modifier = Modifier.padding(4.dp)) {
         Icon(
             painter = painterResource(id = R.drawable.humidity),
             contentDescription = null,
             modifier = Modifier.size(20.dp)
         )
         Text(text = "${weather.humidity} %", style = MaterialTheme.typography.caption)
      }
      Row {
         Icon(
             painter = painterResource(id = R.drawable.pressure),
             contentDescription = null,
             modifier = Modifier.size(20.dp)
         )
         Text(text = "${weather.pressure} psi", style = MaterialTheme.typography.caption)
      }
      Row {
         Icon(
             painter = painterResource(id = R.drawable.wind),
             contentDescription = null,
             modifier = Modifier.size(20.dp)
         )
         Text(text = "${weather.humidity} mph", style = MaterialTheme.typography.caption)
      }
   }

}