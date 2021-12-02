package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.Task2Binding
import java.util.zip.Inflater

class Task2 : AppCompatActivity() {
    lateinit var bindingClass: Task2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = Task2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val textTask2 =
                "override fun onCreate(savedInstanceState: Bundle?) {\n" +
                "   super.onCreate(savedInstanceState)\n" +
                "   setContentView(R.layout.activity_main)\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Мороз и солнце; день чудесный!\")" +
                "\n}" +
                "\n" +
                "override fun onStart() {\n" +
                "   super.onStart()\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Еще ты дремлешь, друг прелестный –\")" +
                "\n}" +
                "\n" +
                "override fun onResume() {\n" +
                "   super.onResume()\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Пора, красавица, проснись;\")" +
                "\n}" +
                "\n" +
                "override fun onPause() {\n" +
                "   super.onPause()\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Открой сомкнуты негой взоры\")" +
                "\n}" +
                "\n" +
                "override fun onStop() {\n" +
                "   super.onStop()\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Навстречу северной Авроры,\")" +
                "\n}" +
                "\n" +
                "override fun onDestroy() {\n" +
                "   super.onDestroy()\n" +
                "\n" +
                "   Log.d(\"MyTag\", \"Звездою севера явись!\")" +
                "\n}"

        bindingClass.tvTask2.text = textTask2
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
                System.exit(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}