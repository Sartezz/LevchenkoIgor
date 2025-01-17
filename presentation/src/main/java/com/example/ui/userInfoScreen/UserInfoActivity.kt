package com.example.ui.userInfoScreen

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.domain.entity.user.User
import com.example.ui.R
import com.example.ui.base.BaseActivity
import com.example.utils.USER_ID
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : BaseActivity<UserInfoPresenter>(), UserInfoContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initPresenter()

        presenter.getUser(intent.getIntExtra(USER_ID, 1))
    }

    override fun initPresenter() {
        presenter = UserInfoPresenter(this)
    }

    override fun getUserSuccess(user: User) {
        Glide.with(this)
            .asBitmap()
            .load("https://s3.amazonaws.com/tinycards/image/36125d06520a2f6acdae39d1221e5ca8")
            .into(userPhoto)
        idID.text = user.id.toString()
        name.text = user.name
        email.text=user.email
        address.text=user.address.city
        phone.text=user.phone
        website.text=user.website
        company.text=user.company.name
        catch_phrase.text=user.company.catchPhrase
    }

    override fun getUserError(error: Throwable) {
        showToast(error.toString())
    }
}
