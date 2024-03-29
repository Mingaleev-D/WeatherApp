package com.example.weatherapp.ui.screens.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.common.DataOrException
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.ui.screens.main.components.MainContent
import com.example.weatherapp.ui.screens.main.components.WeatherAppBar

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

@Composable
fun MainScreen(
    navController: NavController,
    mainViewMode: MainViewModel = hiltViewModel()
) {

   val weatherData = produceState<DataOrException<WeatherResponse, Boolean, Exception>>(
       initialValue = DataOrException(loading = true),
       producer = {
          //  value = mainViewMode.data.value
          value = mainViewMode.getWeatherData(city = "Kazan")
       }
   ).value

   if (weatherData.loading == true) {
      CircularProgressIndicator()
   } else if (weatherData.data != null) {
      MainScaffold(weather = weatherData.data!!, navController = navController)
   }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScaffold(weather: WeatherResponse, navController: NavController) {
   Scaffold(topBar = {
      WeatherAppBar(
          title = weather.city.name,
          navController = navController,
          elevation = 6.dp,
          //icon = Icons.Default.ArrowBack,
          onButtonClicked = {
             Log.d("TAG", "MainScaffold: Button cliked")
          }
      )
   }) {
      MainContent(data = weather)
   }
}
