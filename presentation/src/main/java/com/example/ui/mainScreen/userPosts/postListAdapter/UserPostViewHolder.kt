package com.example.ui.mainScreen.userPosts.postListAdapter

import android.view.View
import com.bumptech.glide.Glide
import com.example.domain.entity.post.UserPost
import com.example.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.post_item.view.*

class UserPostViewHolder(itemView: View) : BaseViewHolder<UserPost>(itemView) {
    override fun bind(item: UserPost, click: (UserPost) -> Unit) {
        Glide.with(itemView)
            .asBitmap()
            .load("https://s3.amazonaws.com/tinycards/image/36125d06520a2f6acdae39d1221e5ca8")
            .into(itemView.image)

        itemView.line1.text = item.body
        itemView.line2.text = item.title

        itemView.setOnClickListener{
            click(item)
        }
    }
}