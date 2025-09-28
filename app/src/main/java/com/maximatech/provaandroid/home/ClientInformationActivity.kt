package com.maximatech.provaandroid.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.maximatech.provaandroid.databinding.ActivityClientInformationBinding
import com.maximatech.provaandroid.home.viewmodel.ClientInformationState
import com.maximatech.provaandroid.home.viewmodel.ClientInformationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientInformationBinding
    private val viewModel: ClientInformationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClientInformationBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setupObservers()
        viewModel.fetchClientInformation()
    }

    private fun setupObservers() {
        viewModel.clientInformation.observe(this) {
            setupLoading(it.state)
        }
    }

    private fun setupLoading(state: ClientInformationState) = binding.progressBar.apply {
        isVisible = state is ClientInformationState.Loading
    }
}