package com.example.di.component

import com.example.app.App
import com.example.di.modules.app.AppModule
import com.example.di.modules.data.DataModule
import com.example.di.modules.data.RetrofitServiceModule
import com.example.di.modules.repository.RepositoryModule
import com.example.ui.userInfoScreen.UserInfoPresenter
import com.example.ui.userPostsScreen.UserPostPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RetrofitServiceModule::class,
        RepositoryModule::class,
        DataModule::class
    ]
)


interface AppComponent {
    fun inject(app: App)
    fun inject(postPresenter: UserPostPresenter)
    fun inject(userPresenter: UserInfoPresenter)
}