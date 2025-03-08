package com.digitalyogi.dailyquotes.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


// Application Class
class QuoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@QuoteApp)
            modules(appModule)
        }
    }
}
