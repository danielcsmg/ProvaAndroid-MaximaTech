package com.maximatech.provaandroid.di

import com.maximatech.provaandroid.data.remote.ApiService
import com.maximatech.provaandroid.core.provideConverterFactory
import com.maximatech.provaandroid.core.provideHttpClient
import com.maximatech.provaandroid.core.provideRetrofit
import com.maximatech.provaandroid.core.provideService
import org.koin.core.module.Module
import org.koin.dsl.module

val maximaTechModules = module {
    viewModels()
    domain()
    repository()
    remoteConfig()
}

private fun Module.viewModels() {
}

private fun Module.domain() {

}

private fun Module.repository() {

}

private fun Module.remoteConfig() {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(),get()) }
    single<ApiService> { provideService(get()) }
}