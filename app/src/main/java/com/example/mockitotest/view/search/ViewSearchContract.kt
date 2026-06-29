package com.example.mockitotest.view.search

import ViewContract
import com.example.mockitotest.model.SearchResult


internal interface ViewSearchContract : ViewContract {
    override fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    override fun displayError()
    override fun displayError(error: String)
    override fun displayLoading(show: Boolean)
}