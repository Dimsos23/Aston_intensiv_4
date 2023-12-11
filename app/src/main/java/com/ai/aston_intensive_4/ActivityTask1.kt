package com.ai.aston_intensive_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ai.aston_intensive_4.databinding.ActivityTask1Binding
import com.ai.aston_intensive_4.fragments.FragmentA

class ActivityTask1 : AppCompatActivity() {

    private lateinit var binding: ActivityTask1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.host_fragment_task1, FragmentA())
            .setReorderingAllowed(true)
            .commit()
    }
}
