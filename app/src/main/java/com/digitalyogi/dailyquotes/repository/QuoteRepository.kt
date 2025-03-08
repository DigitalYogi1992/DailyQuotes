package com.digitalyogi.dailyquotes.repository

import androidx.lifecycle.LiveData
import com.digitalyogi.dailyquotes.data.Quote
import com.digitalyogi.dailyquotes.data.QuoteDao

// Repository
class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getRandomQuote(): LiveData<Quote> = quoteDao.getRandomQuote()
    fun getAllQuotes(): LiveData<List<Quote>> = quoteDao.getAllQuotes()
    suspend fun addQuote(quote: Quote) = quoteDao.insert(quote)
    suspend fun updateQuote(quote: Quote) = quoteDao.updateQuote(quote)
    suspend fun deleteQuote(quote: Quote) = quoteDao.deleteQuote(quote)
}