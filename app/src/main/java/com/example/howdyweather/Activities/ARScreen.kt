package com.example.howdyweather.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.howdyweather.R

class ARScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arscreen)


    }

    fun openRainyAR(view: android.view.View) {
        val intent = Intent(this, RainyScreen::class.java)
        startActivity(intent)
    }

    fun openCloudyAR(view: android.view.View) {
        val intent = Intent(this, CloudyScreen::class.java)
        startActivity(intent)
    }

    fun openSnowyAR(view: android.view.View) {
        val intent = Intent(this, SnowyScreen::class.java)
        startActivity(intent)
    }

}