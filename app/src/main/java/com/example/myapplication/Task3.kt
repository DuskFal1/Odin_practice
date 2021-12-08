package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.myapplication.databinding.Task3Binding
import kotlin.system.exitProcess

class Task3 : AppCompatActivity() {
    private lateinit var bindingClass: Task3Binding
    private var toggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = Task3Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.imTask3.setImage(ImageSource.resource(R.drawable.figma))

        bindingClass.btnTask3.setOnClickListener {
            if(!toggle){

                bindingClass.imTask3.setImage(ImageSource.resource(R.drawable.studio))
                bindingClass.btnTask3.text = getText(R.string.task3ButtonToggleFigma).toString()
                toggle = true
            } else {

                bindingClass.imTask3.setImage(ImageSource.resource(R.drawable.figma))
                bindingClass.btnTask3.text = getText(R.string.task3ButtonToggleAS).toString()
                toggle = false
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