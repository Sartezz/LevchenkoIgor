package com.example.ui.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<Presenter : BasePresenter> : AppCompatActivity() {
    protected lateinit var presenter: Presenter
    abstract fun initPresenter()

    override fun onStart() {
        presenter.onStart()
        super.onStart()
    }

    override fun onStop() {
        presenter.onStop()
        super.onStop()
    }
}