package com.example.ui.mainScreen.userPosts

import com.example.domain.entity.post.UserPost

interface UserPostContract {
    interface Presenter {
        fun getUserPostsList()
    }

    interface View {
        fun onGetPostsSuccess(userPostList: List<UserPost>)
        fun onGetPostsError(error: Throwable)
    }
}