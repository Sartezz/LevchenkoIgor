package com.example.data.repository

import com.example.data.rest.service.Service
import com.example.domain.entity.post.UserPost
import com.example.domain.repository.PostRepository
import io.reactivex.Observable

class PostRepositoryImpl(private val service: Service) : PostRepository {
    override fun getPostsList(): Observable<List<UserPost>> {
        return service.getPostsList()
    }
}