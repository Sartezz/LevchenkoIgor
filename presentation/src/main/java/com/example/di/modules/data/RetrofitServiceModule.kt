package com.example.di.modules.data

import com.example.data.rest.service.Service
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitServiceModule {
    @Singleton
    @Provides
    fun provideService() = Service()
}