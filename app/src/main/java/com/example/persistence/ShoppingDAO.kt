package com.example.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingDAO {
    @Insert
    fun addShoppingItem(shoppingItem: ShoppingModel)

    @Query("SELECT * FROM shoppingmodel")
    fun getAllShoppingItems(): List<ShoppingModel>

    @Delete
    fun delete(shoppingItem: ShoppingModel)
}