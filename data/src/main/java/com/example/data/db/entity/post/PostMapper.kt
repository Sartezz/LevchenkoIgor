package com.example.data.db.entity.post

import com.example.domain.entity.post.UserPost

fun UserPost.transformToPostDb() = PostDB(userId, id, title, body)
fun PostDB.transformToUserPost() = UserPost(userId, id, title, body)