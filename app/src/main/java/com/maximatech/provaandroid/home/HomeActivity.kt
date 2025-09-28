package com.maximatech.provaandroid.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximatech.provaandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}