package com.ai.aston_intensive_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ai.aston_intensive_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonTask1.setOnClickListener {
            startActivity(Intent(this, ActivityTask1::class.java))
        }

        binding.buttonTask2.setOnClickListener {
            startActivity(Intent(this, ActivityTask2::class.java))
        }
    }
}