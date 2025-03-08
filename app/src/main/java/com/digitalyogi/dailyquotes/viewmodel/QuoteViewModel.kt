package com.digitalyogi.dailyquotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalyogi.dailyquotes.data.Quote
import com.digitalyogi.dailyquotes.repository.QuoteRepository
import kotlinx.coroutines.launch

// ViewModel
class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    val randomQuote: LiveData<Quote> = repository.getRandomQuote()
    val allQuotes: LiveData<List<Quote>> = repository.getAllQuotes()

    fun addQuote(text: String) = viewModelScope.launch { repository.addQuote(Quote(text = text)) }
    fun updateQuote(quote: Quote) = viewModelScope.launch { repository.updateQuote(quote) }
    fun deleteQuote(quote: Quote) = viewModelScope.launch { repository.deleteQuote(quote) }
}