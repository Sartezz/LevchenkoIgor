package com.example.data.repository

import com.example.data.db.dao.PostDao
import com.example.data.db.entity.post.transformToPostDb
import com.example.data.db.entity.post.transformToUserPost
import com.example.data.rest.service.Service
import com.example.domain.entity.post.UserPost
import com.example.domain.repository.PostRepository
import io.reactivex.Observable

class PostRepositoryImpl (private val service: Service, private val postDao: PostDao) :
    PostRepository {

    override fun getPostsList(): Observable<List<UserPost>> {
        return postDao.getPosts()
            .toObservable()
            .flatMap { postDB ->
                if (postDB.isEmpty()) {
                    service.getPostsList()
                        .flatMap { postRest ->
                            postRest.map { post ->
                                postDao.addPost(post.transformToPostDb())
                            }
                            Observable.just(postRest)
                        }
                } else {
                    Observable.just(postDB.map {
                        it.transformToUserPost() })
                }
            }
    }
}