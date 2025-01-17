package com.example.app

import android.app.Application
import com.example.di.component.AppComponent
import com.example.di.component.DaggerAppComponent
import com.example.di.modules.app.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    init {
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}