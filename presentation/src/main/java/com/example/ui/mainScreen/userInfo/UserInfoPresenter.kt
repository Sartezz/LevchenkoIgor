package com.example.ui.mainScreen.userInfo

import com.bumptech.glide.Glide
import com.example.data.repository.UserRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.UserRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoPresenter(private val userActivity: UserInfoActivity) : BasePresenter(),
    UserInfoContract.Presenter {

    private val service = Service()
    private val userRepository: UserRepository

    init {
        userRepository = UserRepositoryImpl(service)
    }

    override fun getUser(id: Int) {
        addDisposable(
            userRepository.getUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Glide.with(userActivity)
                        .asBitmap()
                        .load("https://s3.amazonaws.com/tinycards/image/36125d06520a2f6acdae39d1221e5ca8")
                        .into(userActivity.userPhoto)
                    userActivity.idID.append(it.id.toString())
                    userActivity.name.append(it.name)
                    userActivity.email.append(it.email)
                    userActivity.address.append(it.address.city)
                    userActivity.phone.append(it.phone)
                    userActivity.website.append(it.website)
                    userActivity.company.append(it.company.name)
                    userActivity.catch_phrase.append(it.company.catchPhrase)
                }
        )
    }
}