package com.example.mockitotest.view.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mockitotest.R
import com.example.mockitotest.databinding.ActivityDetailsBinding
import com.example.mockitotest.model.SearchResult
import com.example.mockitotest.presenter.details.DetailsPresenter
import com.example.mockitotest.presenter.details.PresenterDetailsContract
import java.util.Locale

class DetailsActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailsBinding
    private val presenter: PresenterDetailsContract = DetailsPresenter(object :ViewDetailsContract {
        override fun setCount(count: Int) {
            setCountText(count)
        }

        override fun displaySearchResults(
            searchResults: List<SearchResult>,
            totalCount: Int
        ) {
            //TODO("Not yet implemented")
        }

        override fun displayError() {
           // TODO("Not yet implemented")
        }

        override fun displayError(error: String) {
            //TODO("Not yet implemented")
        }

        override fun displayLoading(show: Boolean) {
           // TODO("Not yet implemented")
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        val count = intent.getIntExtra(TOTAL_COUNT_EXTRA, 0)
        presenter.setCounter(count)
        setCountText(count)
        binding.decrementButton.setOnClickListener { presenter.onDecrement() }
        binding.incrementButton.setOnClickListener { presenter.onIncrement() }
    }

    private fun setCountText(count: Int) {
        binding.totalCountTextView.text =
            String.format(Locale.getDefault(), getString(R.string.results_count), count)
    }

    companion object {

        const val TOTAL_COUNT_EXTRA = "TOTAL_COUNT_EXTRA"

        fun getIntent(context: Context, totalCount: Int): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(TOTAL_COUNT_EXTRA, totalCount)
            }
        }
    }
}
