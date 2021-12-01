package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.imageView.animate().alpha(1f).translationYBy(400F).setDuration(2500)
        bindingClass.btnStart.animate().alpha(1f).translationYBy(-400F).setDuration(2500)

        bindingClass.btnStart.setOnClickListener {
            val intent = Intent(this, ListTask::class.java)
            startActivity(intent)
        }
    }
}