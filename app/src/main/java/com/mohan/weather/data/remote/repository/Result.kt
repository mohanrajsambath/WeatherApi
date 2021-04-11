package com.mohan.weather.data.remote.repository

import com.sathish.carmap.utils.ErrorResponse

sealed  class Result<out T:Any> {
    data class Success<out T:Any>(val data:T):
        Result<T>()
    data class Error(val data:String):
        Result<Nothing>()
}