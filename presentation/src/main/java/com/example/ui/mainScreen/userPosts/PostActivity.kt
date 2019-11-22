package com.example.ui.mainScreen.userPosts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.post.UserPost
import com.example.ui.R
import com.example.ui.base.BaseActivity
import com.example.ui.mainScreen.userInfo.UserInfoActivity
import com.example.ui.mainScreen.userPosts.postListAdapter.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PostActivity : BaseActivity<UserPostPresenter>(),
    UserPostContract.View {
    override fun initPresenter() {
        presenter = UserPostPresenter(this)
    }

    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        presenter.getUserPostsList()

        adapter.onClick= {
            val intent = Intent (this, UserInfoActivity::class.java)
            intent.putExtra("USER_ID", it.userId)
            startActivity(intent)
        }
    }

    override fun onGetPostsSuccess(userPostList: List<UserPost>) {
        adapter.addItems(userPostList)
    }

    override fun onGetPostsError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

    }

}

