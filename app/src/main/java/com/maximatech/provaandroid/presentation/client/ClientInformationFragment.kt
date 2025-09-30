package com.maximatech.provaandroid.presentation.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.maximatech.provaandroid.databinding.FragmentClientInformationBinding
import com.maximatech.provaandroid.presentation.client.adapter.ClientInformationAdapter
import com.maximatech.provaandroid.presentation.client.adapter.model.ClientInformationItem
import com.maximatech.provaandroid.presentation.client.viewmodel.ClientInformation
import com.maximatech.provaandroid.presentation.client.viewmodel.ClientInformationState
import com.maximatech.provaandroid.presentation.client.viewmodel.ClientInformationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientInformationFragment : Fragment() {
    private lateinit var binding: FragmentClientInformationBinding

    private lateinit var adapter: ClientInformationAdapter

    private val viewModel: ClientInformationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClientInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        viewModel.fetchClientInformation()
    }

    fun setupRecyclerView() {
        adapter = ClientInformationAdapter()
        binding.clientList.layoutManager = LinearLayoutManager(context)
        binding.clientList.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.clientInformation.observe(viewLifecycleOwner) {
            bindView(it)
        }
    }

    private fun bindView(data: ClientInformation) {
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
