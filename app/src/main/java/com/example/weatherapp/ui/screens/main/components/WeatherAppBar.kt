package com.example.weatherapp.ui.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * @author : Mingaleev D
 * @data : 23.05.2023
 */

//@Preview
@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {
   TopAppBar(
       title = {
          Text(
              text = title,
              color = MaterialTheme.colors.onSecondary,
              style = TextStyle(
                  fontWeight = FontWeight.ExtraBold,
                  fontSize = 15.sp
              ),

              )
       },
       actions = {
          if (isMainScreen) {
             IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
             }
             IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = null
                )
             }
          } else {
             Box {

             }
          }
       },
       navigationIcon = {
          if (icon != null) {
             Icon(
                 imageVector = icon,
                 contentDescription = null,
                 tint = MaterialTheme.colors.onSecondary,
                 modifier = Modifier.clickable { onButtonClicked.invoke() }
             )
          }
       },
       backgroundColor = Color.Transparent
   )
}

