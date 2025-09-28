package com.maximatech.provaandroid.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.maximatech.provaandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        binding = ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var dataLoaded = false
        splashScreen.setKeepOnScreenCondition { !dataLoaded }

        Handler(Looper.getMainLooper()).postDelayed({
            dataLoaded = true
        }, 1000)
    }
}