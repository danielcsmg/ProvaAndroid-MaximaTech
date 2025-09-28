package com.maximatech.provaandroid.di

import org.koin.core.module.Module
import org.koin.dsl.module

val maximaTechModules = module {
    viewModels()
    domain()
    repository()
}

private fun Module.viewModels() {

}

private fun Module.domain() {

}

private fun Module.repository() {

}