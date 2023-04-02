package com.example.howdyweather.Utilities

import com.example.howdyweather.Models.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather")
    fun getCurrentWeatherdata(
        @Query("lat") lat:String,
        @Query("lon") lon:String,
        @Query("APPID") appid:String
    ) : Call<WeatherModel>

    @GET("weather")
    fun getCityWeatherdata(
        @Query("q") q:String,
        @Query("APPID") appid:String
    ) : Call<WeatherModel>

}