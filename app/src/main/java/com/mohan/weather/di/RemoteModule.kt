package com.mohan.weather.di

import com.google.android.gms.location.LocationRequest
import com.mohan.weather.data.repo.WeatherService
import com.mohan.weather.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {  provideRetrofit(get())}
    single {  provideLocationRequest()}
    factory {  okHttpClient()}
    factory { WeatherService(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


fun okHttpClient(): OkHttpClient {
    val interceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor()
    interceptor!!.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(interceptor)
        .build()
}


fun  WeatherService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

fun provideLocationRequest(): LocationRequest? {
    return LocationRequest.create()
        .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
        .setInterval(1000)
}