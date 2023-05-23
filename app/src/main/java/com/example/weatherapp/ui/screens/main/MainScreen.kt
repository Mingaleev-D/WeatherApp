package com.example.weatherapp.ui.screens.main

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.common.DataOrException
import com.example.weatherapp.data.model.WeatherResponse

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

@Composable
fun MainScreen(
    navController: NavController,
    mainViewMode: MainViewModel = hiltViewModel()
) {
   ShowData(mainViewMode)
}

@Composable
fun ShowData(mainViewMode: MainViewModel) {
   val weatherData = produceState<DataOrException<WeatherResponse, Boolean, Exception>>(
       initialValue = DataOrException(loading = true),
       producer = {
        //  value = mainViewMode.data.value
          value = mainViewMode.getWeatherData(city = "Москва")
       }
   ).value

   if(weatherData.loading == true){
      CircularProgressIndicator()
   }else if(weatherData.data!= null){
      Text(text = "Main ${weatherData.data!!}")
   }



}