package com.example.di.modules.repository

import com.example.data.repository.PostRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.PostRepository
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(service: Service): PostRepository = PostRepositoryImpl(service)

    @Singleton
    @Provides
    fun provideUserRepository(service: Service): UserRepository = UserRepositoryImpl(service)
}