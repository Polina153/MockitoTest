package com.example.mockitotest.presenter

import com.example.mockitotest.repository.RepositoryCallback

internal interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )
}