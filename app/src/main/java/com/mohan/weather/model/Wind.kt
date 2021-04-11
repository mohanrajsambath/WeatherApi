package com.mohan.weather.model


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val deg: Int = 0, // 240
    @SerializedName("speed")
    val speed: Double = 0.0 // 7.2
)