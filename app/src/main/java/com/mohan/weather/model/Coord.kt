package com.mohan.weather.model


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val lat: Double = 0.0, // 52.52
    @SerializedName("lon")
    val lon: Double = 0.0 // 13.39
)