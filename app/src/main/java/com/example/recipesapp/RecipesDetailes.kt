package com.example.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipesapp.databinding.ActivityMainBinding
import com.example.recipesapp.databinding.ActivityRecipesDetailesBinding

class RecipesDetailes : AppCompatActivity() {

    private lateinit var binding: ActivityRecipesDetailesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesDetailesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        val intent = intent
        //Casting --> as Food
        val selectedfood = intent.getSerializableExtra("food") as Food

        binding.nameText.text = selectedfood.name
        binding.recipeText.text = selectedfood.tarif
        binding.imageView.setImageResource(selectedfood.gorsel)


    }
}