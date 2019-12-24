package com.example.data.db.entity.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostDB(
    var userId: Int,
    @PrimaryKey
    var id: Int,
    var title: String,
    var body: String
)