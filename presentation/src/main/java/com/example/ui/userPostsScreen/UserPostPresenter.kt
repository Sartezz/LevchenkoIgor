package com.example.ui.userPostsScreen

import com.example.app.App
import com.example.domain.repository.PostRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserPostPresenter(private val mvpView: UserPostContract.View) : BasePresenter(),
    UserPostContract.Presenter {

    @Inject
    lateinit var postRepository: PostRepository

    init {
        App.appComponent.inject(this)
    }

    override fun getUserPostsList() {
        addDisposable(
            postRepository.getPostsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { mvpView.onGetPostsSuccess(it) },
                    { mvpView.onGetPostsError(it) }
                )
        )
    }
}