package com.example.persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.persistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
private lateinit var myShoppingList: MutableList<ShoppingModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
          myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList)

        binding.recyclerView.adapter = myShoppingAdapter
        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database-name"
        ).allowMainThreadQueries().build()

        val shoppingDAO = db.shoppingDao()
        myShoppingList = shoppingDAO.getAllShoppingItems().toMutableList()
        myShoppingAdapter.notifyDataSetChanged()
        binding.recyclerView.adapter = myShoppingAdapter

        myShoppingAdapter.notifyDataSetChanged()

        binding.button.setOnClickListener {
            val category: String = binding.category.toString()
            val description: String = binding.description.toString()

            val shoppingItem = ShoppingModel(category, description)
             shoppingDAO.addShoppingItem(shoppingItem)


        }

    }
}