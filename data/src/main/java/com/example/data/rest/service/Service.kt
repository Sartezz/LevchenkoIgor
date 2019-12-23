package com.example.data.rest.service

import com.example.data.rest.api.PostApi
import com.example.data.rest.api.UserApi
import com.example.domain.entity.post.UserPost
import com.example.domain.entity.user.User
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Service {
    private val userApi: UserApi
    private val postApi: PostApi
    private val logging = HttpLoggingInterceptor()

    init {
        logging.level = HttpLoggingInterceptor.Level.Body
        
        val okHttpBuilder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)

        val gson = GsonBuilder()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(gson.create()))
            .client(okHttpBuilder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
        postApi = retrofit.create(PostApi::class.java)

    }

    fun getUser(id: Int): Observable<User> {
        return userApi.getUser(id)
    }

    fun getPostsList(): Observable<List<UserPost>> {
        return postApi.getPostsList()
    }
}
