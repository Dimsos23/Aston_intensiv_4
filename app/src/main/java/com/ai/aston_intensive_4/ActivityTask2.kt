package com.ai.aston_intensive_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ai.aston_intensive_4.fragments.ContactFragment

class ActivityTask2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        val fragmentManager = supportFragmentManager
        val fragmentContact = ContactFragment()
        fragmentManager.beginTransaction()
            .replace(R.id.host_fragment_task2, fragmentContact)
            .setReorderingAllowed(true)
            .commit()
    }
}