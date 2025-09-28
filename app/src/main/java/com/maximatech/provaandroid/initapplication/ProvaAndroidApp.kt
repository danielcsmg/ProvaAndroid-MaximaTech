package com.maximatech.provaandroid.initapplication

import android.app.Application
import com.maximatech.provaandroid.di.maximaTechModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ProvaAndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ProvaAndroidApp)
            modules(maximaTechModules)
        }
    }
}