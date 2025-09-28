package com.maximatech.provaandroid.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class ClientInformationViewModel : ViewModel() {
    private val _clientInformation = MutableLiveData<ClientInformation>()
    val clientInformation: LiveData<ClientInformation> = _clientInformation

    fun fetchClientInformation() {
        _clientInformation.value = ClientInformation()
        viewModelScope.launch {
            delay(2000)
            _clientInformation.value = ClientInformation(
                ClientInformationData(
                    name = "Daniel"
                )
            )
        }
    }
}