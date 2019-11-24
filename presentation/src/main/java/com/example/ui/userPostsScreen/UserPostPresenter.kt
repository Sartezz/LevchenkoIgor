package com.example.ui.userPostsScreen

import com.example.data.repository.PostRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.PostRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserPostPresenter(private val mvpView: UserPostContract.View) : BasePresenter(),
    UserPostContract.Presenter {
    private var service: Service = Service()
    private var postRepository: PostRepository

    init {
        postRepository = PostRepositoryImpl(service)
    }

    override fun getUserPostsList() {
        addDisposable(
            postRepository.getPostsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        mvpView.onGetPostsSuccess(it)
                    },
                    {
                        mvpView.onGetPostsError(it)
                    }
                )
        )
    }
}