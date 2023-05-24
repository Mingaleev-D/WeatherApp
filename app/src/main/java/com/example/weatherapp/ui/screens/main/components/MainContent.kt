package com.example.weatherapp.ui.screens.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.common.Constants
import com.example.weatherapp.data.common.formatDate
import com.example.weatherapp.data.common.formatDecimals
import com.example.weatherapp.data.model.WeatherResponse

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

@SuppressLint("InvalidColorHexValue")
@Composable fun MainContent(data: WeatherResponse) {

   val imageUrl = Constants.BASE_URL_IMAGE + "${data.list[0].weather[0].icon}.png"
   val weatherItem = data.list[0]

   Column(
       modifier = Modifier
           .padding(4.dp)
           .fillMaxWidth(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Text(
          text = formatDate(data.list[0].dt),
          style = MaterialTheme.typography.caption,
          color = MaterialTheme.colors.onSecondary,
          fontWeight = FontWeight.SemiBold,
          modifier = Modifier.padding(6.dp)
      )
      Surface(
          modifier = Modifier
              .padding(4.dp)
              .size(200.dp),
          shape = CircleShape,
          color = Color(0xFFCE93D8)
      ) {
         Column(
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
            WeatherStateImage(imageUrl = imageUrl)
            Text(
                text = formatDecimals(data.list[0].temp.day) + "°",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
            Text(text = data.list[0].weather[0].main, fontStyle = FontStyle.Italic)
         }
      }
      HumidityWindPressureRow(weather = weatherItem)
      Divider()
      SunsetSunRiseRow(weather = weatherItem)
      Text(
          text = "Whis Week",
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold
      )
      Surface(
          modifier = Modifier
              .fillMaxWidth()
              .fillMaxHeight(),
          color = Color(0xffeef1ef),
          shape = RoundedCornerShape(14.dp)
      ) {
         LazyColumn(
             modifier = Modifier.padding(2.dp),
             contentPadding = PaddingValues(1.dp)
         ) {
            items(items = data.list) { item ->
               WeatherDetailRow(weather = item)
            }
         }
      }
   }
}