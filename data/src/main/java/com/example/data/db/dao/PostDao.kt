package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.db.entity.post.PostDB
import io.reactivex.Flowable

@Dao
interface PostDao {

    @Insert
    fun addPost(post: PostDB)

    @Delete
    fun deletePost(post: PostDB)

    @Query("SELECT * FROM posts")
    fun getPosts(): Flowable<List<PostDB>>

}