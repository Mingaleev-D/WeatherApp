package com.example.weatherapp.data.api

import com.example.weatherapp.data.common.Constants.API_KEY
import com.example.weatherapp.data.common.Constants.BASE_LANGUAGE
import com.example.weatherapp.data.common.Constants.BASE_UNITS
import com.example.weatherapp.data.common.Constants.BASE_VALUE
import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

interface WeatherApiService {

   @GET(value = BASE_VALUE)
   suspend fun getWeather(
       @Query("q") query: String,
       @Query("lang") language: String = BASE_LANGUAGE,
       @Query("appid") apiKey: String = API_KEY,
       @Query("units") units: String = BASE_UNITS,
   ): WeatherResponse
}