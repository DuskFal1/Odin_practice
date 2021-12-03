package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    //инициализируем View binding
    private lateinit var bindingClass: ActivityMainBinding

    //рисуем наш layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    //запускаем анимацию
        bindingClass.imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_main_logo))
        bindingClass.btnStart.animate().translationYBy(-400F).duration = 1350

    //обработчик для кнопки приступить
        bindingClass.btnStart.setOnClickListener {
            val intent = Intent(this, ListTask::class.java)
            startActivity(intent)
            finish()
        }
    }

    //рисуем меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //обрабатываем кнопки меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_exit -> {
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}