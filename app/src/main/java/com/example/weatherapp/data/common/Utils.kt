package com.example.weatherapp.data.common

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author : Mingaleev D
 * @data : 24.05.2023
 */

fun formatDate(timestamp:Int):String{
   val sdf = SimpleDateFormat("EEE, d MMM")
   val data = Date(timestamp.toLong() * 1000)
   return sdf.format(data)
}

fun formatDateTime(timestamp:Int):String{
   val sdf = SimpleDateFormat("hh:mm:aa")
   val data = Date(timestamp.toLong() * 1000)
   return sdf.format(data)
}
fun formatDecimals(item:Double):String{
   return "%.0f".format(item)
}