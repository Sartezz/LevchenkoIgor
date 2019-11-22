package com.example.domain.repository

import com.example.domain.entity.user.User
import io.reactivex.Observable

interface UserRepository {
    fun getUser(id: Int) : Observable <User>
}