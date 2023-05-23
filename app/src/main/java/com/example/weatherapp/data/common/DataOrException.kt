package com.example.weatherapp.data.common

class DataOrException<T, Boolean, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var ex: E? = null
)
