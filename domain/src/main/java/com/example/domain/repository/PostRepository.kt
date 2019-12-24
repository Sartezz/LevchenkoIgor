package com.example.domain.repository

import com.example.domain.entity.post.UserPost
import io.reactivex.Observable

interface PostRepository {
    fun getPostsList(): Observable<List<UserPost>>
}