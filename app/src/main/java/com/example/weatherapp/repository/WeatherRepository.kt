package com.example.weatherapp.repository

import com.example.weatherapp.data.api.WeatherApiService
import com.example.weatherapp.data.common.DataOrException
import com.example.weatherapp.data.model.WeatherResponse
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

class WeatherRepository @Inject constructor(private val api: WeatherApiService) {

   suspend fun getWeather(cityQuery: String): DataOrException<WeatherResponse, Boolean, Exception> {
      val response = try {
         api.getWeather(query = cityQuery)
      } catch (ex: Exception) {
         return DataOrException(ex = ex)
      }
      return DataOrException(data = response)
   }
}