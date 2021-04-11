package com.mohan.weather.model


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    val country: String = "", // DE
    @SerializedName("id")
    val id: Int = 0, // 1275
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1571203961
    @SerializedName("sunset")
    val sunset: Int = 0, // 1571242269
    @SerializedName("type")
    val type: Int = 0 // 1
)