package com.example.weatherapp.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.common.Constants
import com.example.weatherapp.data.common.formatDate
import com.example.weatherapp.data.common.formatDecimals
import com.example.weatherapp.data.model.WeatherItem

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

@Composable fun WeatherDetailRow(weather: WeatherItem) {
   val imageUrl = Constants.BASE_URL_IMAGE + "${weather.weather[0].icon}.png"
   Surface(
       modifier = Modifier
           .padding(3.dp)
           .fillMaxWidth(),
       shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
       color = Color.White
   ) {
      Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
         Text(
             text = formatDate(weather.dt).split(",")[0],
             modifier = Modifier.padding(start = 5.dp)
         )
         WeatherStateImage(imageUrl = imageUrl)
         Surface(
             modifier = Modifier.padding(1.dp),
             shape = CircleShape,
             color = Color(0xFFCE93D8)
         ) {
            Text(
                text = weather.weather[0].description,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.caption
            )
         }
         Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
            ) {
               append(formatDecimals(weather.temp.max) + "°")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF9FA8DA),
                    fontWeight = FontWeight.SemiBold
                )
            ) {
               append(formatDecimals(weather.temp.min) + "°")
            }
         })
      }
   }
}