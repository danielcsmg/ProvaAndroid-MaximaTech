package com.maximatech.provaandroid.di

import com.maximatech.provaandroid.home.viewmodel.ClientInformationViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val maximaTechModules = module {
    viewModels()
    domain()
    repository()
}

private fun Module.viewModels() {
    viewModel { ClientInformationViewModel() }
}

private fun Module.domain() {

}

private fun Module.repository() {

}