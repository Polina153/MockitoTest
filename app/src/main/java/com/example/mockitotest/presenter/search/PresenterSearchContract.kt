package com.example.mockitotest.presenter.search

import com.example.mockitotest.presenter.PresenterContract


internal interface PresenterSearchContract : PresenterContract {
    override fun searchGitHub(searchQuery: String)
    //onAttach
    //onDetach
}