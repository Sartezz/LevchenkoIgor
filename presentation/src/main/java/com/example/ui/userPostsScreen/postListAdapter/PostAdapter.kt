package com.example.ui.userPostsScreen.postListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entity.post.UserPost
import com.example.ui.R
import com.example.ui.base.BaseAdapter

class PostAdapter : BaseAdapter<UserPostViewHolder, UserPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostViewHolder {
        return UserPostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)
        )
    }
}