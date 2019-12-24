package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.db.dao.PostDao
import com.example.data.db.dao.UserDao
import com.example.data.db.entity.post.PostDB
import com.example.data.db.entity.user.Converter
import com.example.data.db.entity.user.UserDB
import com.example.utils.DATABASE_NAME

@Database(entities = [PostDB::class, UserDB::class], version = 3, exportSchema = false)
@TypeConverters(Converter::class)

abstract class AppDataBase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
}