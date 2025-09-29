package com.maximatech.provaandroid.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximatech.provaandroid.data.remote.ApiService
import com.maximatech.provaandroid.data.remote.entity.ClientResponse
import com.maximatech.provaandroid.toData
import kotlinx.coroutines.launch

internal class ClientInformationViewModel(
    private val apiService: ApiService,
) : ViewModel() {
    private val _clientInformation = MutableLiveData<ClientInformation>()
    val clientInformation: LiveData<ClientInformation> = _clientInformation

    fun fetchClientInformation() {
        _clientInformation.value = ClientInformation()
        viewModelScope.launch {
            getClientInformation()?.let {
                _clientInformation.value = it.toData()
            }
            _clientInformation.value = ClientInformation(error = ClientError(""))
        }
    }

    private suspend fun getClientInformation(): ClientResponse? {
        return try {
            apiService.getClientInformation()
        } catch (e: Exception) {
            null
        }
    }
}