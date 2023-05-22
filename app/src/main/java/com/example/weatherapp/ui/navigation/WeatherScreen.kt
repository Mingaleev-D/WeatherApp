package com.example.weatherapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.WeatherSplashScreen
import com.example.weatherapp.ui.screens.main.MainScreen

/**
 * @author : Mingaleev D
 * @data : 22.05.2023
 */

enum class WeatherScreen {
   SplashScreen,
   MainScreen,
   AboutScreen,
   FavoriteScreen,
   SearchScreen,
   SettingScreen
}

@Composable
fun WeatherNavigation() {
   val navController = rememberNavController()
   NavHost(
       navController = navController,
       startDestination = WeatherScreen.SplashScreen.name
   ) {
      composable(route = WeatherScreen.SplashScreen.name) {
         WeatherSplashScreen(navController = navController)
      }
      composable(route = WeatherScreen.MainScreen.name) {
         MainScreen(navController = navController)
      }
   }
}