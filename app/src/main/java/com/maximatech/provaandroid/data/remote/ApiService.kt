package com.maximatech.provaandroid.data.remote

import com.maximatech.provaandroid.data.remote.entity.ClientResponse
import retrofit2.http.GET


internal interface ApiService {
    @GET("/android/cliente")
    suspend fun getClientInformation(): ClientResponse
}