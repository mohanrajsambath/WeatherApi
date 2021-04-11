////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2021.                                                         /
// Project Name : Weather                                                      /
// Module Name : Weather.app                                                   /
// Created by : mohan                                                          /
// Created on : 9/4/21 2:34 AM                                                 /
// Updated on : 9/4/21 2:33 AM                                                 /
// File Name : WeatherInfoModel.kt                                             /
// Class Name : WeatherInfoModel.kt                                            /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package com.mohan.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherInfoModel(
    /*Json objects are searlized by using GSON serialization*/
    @SerializedName("base")
    val base: String = "", // stations
    @SerializedName("clouds")
    val clouds: Clouds = Clouds(),
    @SerializedName("cod")
    val cod: Int = 0, // 200
    @SerializedName("coord")
    val coord: Coord = Coord(),
    @SerializedName("dt")
    val dt: Int = 0, // 1571235600
    @SerializedName("id")
    val id: Int = 0, // 2950159
    @SerializedName("main")
    val main: Main = Main(),
    @SerializedName("name")
    val name: String = "", // Berlin
    @SerializedName("rain")
    val rain: Rain = Rain(),
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("timezone")
    val timezone: Int = 0, // 7200
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("wind")
    val wind: Wind = Wind()

)
