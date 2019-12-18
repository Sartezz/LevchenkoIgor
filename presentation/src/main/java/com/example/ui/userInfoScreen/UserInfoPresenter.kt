package com.example.ui.userInfoScreen

import android.util.Log
import com.example.app.App
import com.example.domain.repository.UserRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserInfoPresenter(private val mvpView: UserInfoContract.View) : BasePresenter(),
    UserInfoContract.Presenter {

    @Inject
    lateinit var userRepository: UserRepository

    init {
        App.appComponent.inject(this)
    }

    override fun getUser(id: Int) {
        addDisposable(
            userRepository.getUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.d("SUCCESS", it.toString())
                        mvpView.getUserSuccess(it)
                    },
                    {
                        Log.d("ERROR", it.toString())
                        mvpView.getUserError(it)
                    }
                )
        )
    }
}