package com.maximatech.provaandroid.core

import com.maximatech.provaandroid.data.remote.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL_GET = "https://private-anon-19ab070be0-maximatech.apiary-mock.com"

internal fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}


internal fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


internal fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL_GET)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

internal fun provideService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

