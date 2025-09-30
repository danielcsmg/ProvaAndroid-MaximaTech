package com.maximatech.provaandroid.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximatech.provaandroid.databinding.ActivityClientInformationBinding
import com.maximatech.provaandroid.home.adapter.ClientInformationAdapter
import com.maximatech.provaandroid.home.model.ClientInformationItem
import com.maximatech.provaandroid.home.viewmodel.ClientInformation
import com.maximatech.provaandroid.home.viewmodel.ClientInformationState
import com.maximatech.provaandroid.home.viewmodel.ClientInformationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientInformationBinding

    private lateinit var adapter: ClientInformationAdapter

    private val viewModel: ClientInformationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClientInformationBinding.inflate(layoutInflater)
        adapter = ClientInformationAdapter()
        binding.clientList.layoutManager = LinearLayoutManager(this)
        binding.clientList.adapter = adapter
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
            bindView(it)
        }
    }

    private fun ClientInformationActivity.bindView(data: ClientInformation) {
        when (data.state) {
            is ClientInformationState.Success -> {
                data.data?.let { client ->
                    adapter.updateItems(
                        listOf(
                            ClientInformationItem(
                                title = client.corporateName,
                                subtitle = client.businessActivity
                            )
                        )
                    )
                }
            }

            ClientInformationState.Error -> {}
            ClientInformationState.Loading -> {}
        }
        setupLoading(data.state)
    }

    private fun setupLoading(state: ClientInformationState) = binding.progressBar.apply {
        isVisible = state is ClientInformationState.Loading
    }
}
