package com.example.di.modules.repository

import com.example.data.db.dao.PostDao
import com.example.data.db.dao.UserDao
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
    fun providePostRepository(service: Service, postDao: PostDao): PostRepository =
        PostRepositoryImpl(service, postDao)

    @Singleton
    @Provides
    fun provideUserRepository(service: Service, userDao: UserDao): UserRepository =
        UserRepositoryImpl(service, userDao)
}