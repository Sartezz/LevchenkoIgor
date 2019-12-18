package com.example.data.repository

import android.util.Log
import com.example.data.db.dao.UserDao
import com.example.data.db.entity.user.transformToUser
import com.example.data.db.entity.user.transformToUserDb
import com.example.data.rest.service.Service
import com.example.domain.entity.user.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl(private val service: Service, private val userDao: UserDao) :
    UserRepository {
    override fun getUserDao(id: Int): Observable<User> {
        return userDao.getUser(id)
            .toObservable()
            .map {
                it[0].transformToUser()
            }
    }

    override fun getUser(id: Int): Observable<User> {
        return userDao.getUser(id)
            .toObservable()
            .flatMap { userDb ->
                Log.d("BBB", userDb.toString())
                if (userDb.isEmpty()) {
                    service.getUser(id)
                        .flatMap {
                            Log.d("AAAA",it.toString())
                            userDao.addUser(it.transformToUserDb())
                            Observable.just(it)
                        }
                } else {
                    Log.d("CCC",userDb.toString())
                    Observable.just(userDb[0].transformToUser())
                }
            }
    }
}







