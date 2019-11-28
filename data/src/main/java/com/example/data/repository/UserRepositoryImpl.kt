package com.example.data.repository

import com.example.data.db.dao.UserDao
import com.example.data.rest.service.Service
import com.example.domain.entity.user.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl (private val service: Service, private val userDao: UserDao) :
    UserRepository {
    override fun getUser(id: Int): Observable<User> {
        return service.getUser(id)
    }
}

