package com.example.weatherapp.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

@Composable fun WeatherStateImage(imageUrl: String) {
   Image(
       painter = rememberImagePainter(imageUrl),
       contentDescription = null,
       modifier = Modifier.size(80.dp)
   )
}