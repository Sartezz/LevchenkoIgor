package com.example.di.modules.data

import android.content.Context
import com.example.data.db.AppDataBase
import com.example.data.db.dao.PostDao
import com.example.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context) : AppDataBase = AppDataBase.getInstance(context)

    @Singleton
    @Provides
    fun providePostDao(dataBase: AppDataBase) : PostDao = dataBase.postDao()

    @Singleton
    @Provides
    fun provideUserDao(dataBase: AppDataBase) : UserDao = dataBase.userDao()
}