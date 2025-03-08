package com.digitalyogi.dailyquotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Room Database
@Entity(tableName = "quotes")
data class Quote(@PrimaryKey(autoGenerate = true) val id: Int = 0, var text: String)
