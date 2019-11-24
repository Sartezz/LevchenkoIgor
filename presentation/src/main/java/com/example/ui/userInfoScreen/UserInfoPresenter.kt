package com.example.ui.userInfoScreen

import com.example.data.repository.UserRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.UserRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserInfoPresenter(private val mvpView: UserInfoContract.View) : BasePresenter(),
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
                .subscribe(
                    {
                        mvpView.getUserSuccess(it)
                    },
                    {
                        mvpView.getUserError(it)
                    }
                )
        )
    }
}