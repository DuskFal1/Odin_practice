package com.example.myapplication

import android.Manifest.permission.CAMERA
import android.app.ListActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.databinding.TaskIntentsBinding

class TaskIntents : ListActivity() {
    private lateinit var bindingClass: TaskIntentsBinding

    private val intentsList: Array<String> = arrayOf(
        "Открыть камеру", "Открыть браузер",
        "Открыть контакты", "Позвонить"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = TaskIntentsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this, R.layout.simple_list_item_1, intentsList)
        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var item: String = listAdapter.getItem(position) as String
        when (item){

            "Открыть камеру" -> {
                val takePictureIntent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
                startActivity(takePictureIntent)
            }

            "Открыть браузер" -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://odin.study"))
                startActivity(browserIntent)
            }

            "Открыть контакты" -> {

                val pickIntent = Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
                startActivity(pickIntent)
            }

            "Позвонить" -> {
                val callIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + "123456789"))
                startActivity(callIntent)
            }
        }
    }

    //обрабатываем кнопку назад
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListTask::class.java)
        startActivity(intent)
    }
}