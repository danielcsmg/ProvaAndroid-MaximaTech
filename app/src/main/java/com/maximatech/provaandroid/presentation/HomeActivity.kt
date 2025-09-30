package com.maximatech.provaandroid.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.maximatech.provaandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        
    }
}