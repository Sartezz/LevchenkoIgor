package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.db.entity.user.UserDB

@Dao
interface UserDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserDB)

    @Delete
    fun deleteUser(user: UserDB)
}

//    @Query("SELECT * FROM users")
//    fun getUser(id: Int): Observable<UserDB>