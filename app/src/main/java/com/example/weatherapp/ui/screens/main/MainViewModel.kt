package com.example.weatherapp.ui.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.common.DataOrException
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

   suspend fun getWeatherData(city:String):DataOrException<WeatherResponse, Boolean, Exception>{
      return repository.getWeather(cityQuery = city)
   }

//   val data:MutableState<DataOrException<WeatherResponse, Boolean, Exception>> =
//       mutableStateOf(DataOrException(null, true, Exception("err")))

//   init {
//      loadWeather()
//   }
//
//   private fun loadWeather() {
//      getWeather("Moscow")
//   }

//   private fun getWeather(city: String) {
//      viewModelScope.launch {
//         if(city.isEmpty()) return@launch
//         data.value.loading = true
//         data.value = repository.getWeather(cityQuery = city)
//         if(data.value.data.toString().isNotEmpty())  data.value.loading = false
//      }
//      Log.d("TAG", "getWeather: ${data.value.data.toString()}")
//   }
}