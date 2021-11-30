package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass: ActivityMain2Binding

    var firstPlayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.tv.text = "[a, b, c, d, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]"
//        bindingClass.btn1.setOnClickListener {
//            val list = ('a'..'z').toMutableList()
//            bindingClass.tv.text = list.toString()
//        }


            bindingClass.btn2.setOnClickListener {
                if(!firstPlayed) {

                    var list = mutableListOf<Char>() //создаем список List символьных значений Char
                    for (i in 'a'..'z') {            //пробегаемся циклом по алфавиту
                        list.add(i)                  //добавляем букву в алфавит
                    }
                    list.removeAll() { it.code % 2 != 0 }//удаляем нечетные числа
                    bindingClass.tv.text =
                        list.toString()   //проходим циклом по алфавиту, печатаем каждую букву через пробел
                    bindingClass.btn2.text = "Показать исходный алфавит"
                    firstPlayed = true
                }
                else{

                        val list = ('a'..'z').toMutableList()
                        bindingClass.tv.text = list.toString()
                        firstPlayed = false
                    }
                }

        }
}