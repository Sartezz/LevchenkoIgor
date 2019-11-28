package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.entity.user.UserDB
import io.reactivex.Observable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserDB)

    @Delete
    fun deleteUser(user: UserDB)

//    @Query("SELECT * FROM users")
//    fun getUser(id: Int): Observable<UserDB>
}

