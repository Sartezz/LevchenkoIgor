package com.example.ui.mainScreen.userPosts

import com.example.data.repository.PostRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.PostRepository
import com.example.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserPostPresenter(private val activity: PostActivity) : BasePresenter(),
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
                        activity.onGetPostsSuccess(it)
                    },
                    {
                        activity.onGetPostsError(it)
                    }
                )
        )
    }
}