package com.example.jankomarket.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.jankomarket.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryButton=findViewById<Button>(R.id.categoryButton)
        categoryButton.setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }
    }
}