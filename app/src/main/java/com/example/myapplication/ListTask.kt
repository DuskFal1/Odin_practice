package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ListTaskBinding

class ListTask : AppCompatActivity() {
    lateinit var bindingClass: ListTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ListTaskBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btnTask1.setOnClickListener {
            val intent = Intent(this, Task1::class.java)
            startActivity(intent)
        }
    }
}