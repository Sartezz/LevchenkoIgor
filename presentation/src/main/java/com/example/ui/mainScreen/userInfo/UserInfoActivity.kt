package com.example.ui.mainScreen.userInfo

import android.os.Bundle
import com.example.ui.R
import com.example.ui.base.BaseActivity

class UserInfoActivity : BaseActivity<UserInfoPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initPresenter()

        presenter.getUser(intent.getIntExtra("USER_ID", 1))
    }

    override fun initPresenter() {
        presenter = UserInfoPresenter(this)
    }

}
