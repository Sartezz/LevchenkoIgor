package com.example.ui.userInfoScreen

import com.example.domain.entity.user.User

interface UserInfoContract {
    interface Presenter {
        fun getUser(id:Int)
    }

    interface View  {
        fun getUserSuccess(user: User)
        fun getUserError(error: Throwable)
    }
}