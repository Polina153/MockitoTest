package com.example.mockitotest.presenter.details

import com.example.mockitotest.presenter.PresenterContract


internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
