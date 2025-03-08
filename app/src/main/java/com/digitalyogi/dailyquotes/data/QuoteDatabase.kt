package com.digitalyogi.dailyquotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null
        fun getInstance(context: Context): QuoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java, "quote_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}