package com.example.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingModel(


    val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0


)
