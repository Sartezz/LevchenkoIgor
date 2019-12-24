package com.example.data.rest.api

import com.example.domain.entity.post.UserPost
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPostsList(): Observable<List<UserPost>>
}