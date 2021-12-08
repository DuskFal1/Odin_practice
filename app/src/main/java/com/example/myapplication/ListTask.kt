package com.example.myapplication

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.databinding.ListTaskBinding
import kotlin.system.exitProcess

class ListTask : ListActivity(){
    private lateinit var bindingClass: ListTaskBinding

    //создаем массив стрингов
    var list: Array<String> = arrayOf(
        "Задание 1", "Задание 2",
        "Задание 3", "Задание 4",
        "Intents"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ListTaskBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        //создаем массив для адаптера и получаем в него значения наш класс/лейаут для 1 позиции/ список из массива list
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this, R.layout.simple_list_item_1, list)
        // присываеваем адаптер переменной
        listAdapter = adapter
    }


    //обработка кнопок заданий
    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var item: String = listAdapter.getItem(position) as String
        when (item) {

            "Задание 1" -> {
                val intent = Intent(this, Task1::class.java)
                startActivity(intent)
                finish()
            }

            "Задание 2" -> {
                val intent = Intent(this, Task2::class.java)
                startActivity(intent)
                finish()
            }

            "Задание 3" -> {
                val intent = Intent(this, Task3::class.java)
                startActivity(intent)
                finish()
            }

            "Задание 4" -> {

            }

            "Intents" -> {
                val intent = Intent(this, TaskIntents::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tasks, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.action_exit -> {
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //обрабатываем кнопку назад
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}