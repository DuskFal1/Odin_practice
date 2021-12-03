package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.Task1Binding
import kotlin.system.exitProcess

class Task1 : AppCompatActivity() {
    private lateinit var bindingClass: Task1Binding

    private var firstPlayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = Task1Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    //отрисовываем изначальный text view
        bindingClass.tv.text = "[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]"

    //обрабатываем кнопку выполнения задачи
        bindingClass.btn2.setOnClickListener {
            //проверка состояния кнопки
            if(!firstPlayed) {
                val list = mutableListOf<Char>()                    //создаем список List символьных значений Char
                for (i in 'a'..'z') {                               //пробегаемся циклом по алфавиту
                    list.add(i)                                     //добавляем букву в алфавит
                }
                list.removeAll { it.code % 2 != 0 }                 //удаляем нечетные числа
                bindingClass.tv.text = list.toString()              //проходим циклом по алфавиту, печатаем каждую букву через пробел
                bindingClass.btn2.text = "Показать исходный алфавит"
                firstPlayed = true                                  //переключаем в положение true
            }
            else{
                val list = ('a'..'z').toMutableList()               //создаем список с буквами алфавита
                bindingClass.tv.text = list.toString()              //передаем список в текст
                bindingClass.btn2.text = "Показать четный алфавит"
                firstPlayed = false                                 //переключая в положение false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_task, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_to_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.action_to_tasks -> {
                val intent = Intent(this, ListTask::class.java)
                startActivity(intent)
                finish()
            }

            R.id.action_exit -> {
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListTask::class.java)
        startActivity(intent)
    }
}