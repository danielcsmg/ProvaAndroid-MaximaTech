package com.maximatech.provaandroid.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximatech.provaandroid.R
import com.maximatech.provaandroid.databinding.ActivityHomeBinding
import com.maximatech.provaandroid.presentation.client.ClientInformationFragment

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ClientInformationFragment())
            .commit()
    }
}
