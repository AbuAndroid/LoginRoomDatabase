package com.example.loginroomdatabase

import android.app.Application
import com.example.loginroomdatabase.di.module.Test
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppMain:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppMain)
            modules(Test.modules())
        }
    }
}