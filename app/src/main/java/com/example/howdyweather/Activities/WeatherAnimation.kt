package com.example.howdyweather.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDelegate
import com.example.howdyweather.R
import com.example.howdyweather.databinding.ActivityWeatherAnimationBinding
import com.github.matteobattilana.weather.PrecipType

class WeatherAnimation : AppCompatActivity() {

    lateinit var binding : ActivityWeatherAnimationBinding
    lateinit var weather: PrecipType
    lateinit var weatherText: String
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.bttnWeather.setOnClickListener {
            changeWeather()
        }
    }

    private fun changeWeather(){
        var weatherSpeed = 0
        var weatherParticles = 0f

        if (number<2) ++number else number = 0

        when(number){
            0 -> {
                weather = PrecipType.CLEAR
                weatherText = "Clear"
            }
            1 -> {
                weather = PrecipType.SNOW
                weatherText = "Snow"
                weatherParticles = 10f
                weatherSpeed = 200
            }
            2 -> {
                weather = PrecipType.RAIN
                weatherText = "Rain"
                weatherParticles = 60f
                weatherSpeed = 600
            }
        }

        binding.tvWeather.text = weatherText
        binding.wvWeatherView.apply {
            setWeatherData(weather)
            speed = weatherSpeed
            emissionRate = weatherParticles
            angle = 45
            fadeOutPercent = .85f
        }
    }

}