package com.example.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {
    private val disposableList  = CompositeDisposable()

    fun onStart(){

    }

    fun onStop(){
        disposableList.clear()
    }

    fun addDisposable(disposable:Disposable){
        disposableList.add(disposable)
    }

}