package com.digitalyogi.dailyquotes.di

import com.digitalyogi.dailyquotes.data.QuoteDatabase
import com.digitalyogi.dailyquotes.repository.QuoteRepository
import com.digitalyogi.dailyquotes.viewmodel.QuoteViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


// Koin Module
val appModule = module {
    single { QuoteDatabase.getInstance(get()).quoteDao() }
    single { QuoteRepository(get()) }
    viewModel { QuoteViewModel(get()) }
}