package com.example.cankarademirodev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ResultActivity : AppCompatActivity() {

    lateinit var listview1: ListView
    lateinit var listview2: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        listview1=findViewById(R.id.result_listview1)
        listview2=findViewById(R.id.result_listview2)

        val list1 = intent.getStringArrayListExtra("list1")
        val list2 = intent.getStringArrayListExtra("list2")

        val adapter1 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1 ?: emptyList())
        listview1.adapter = adapter1

        val adapter2 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list2 ?: emptyList())
        listview2.adapter = adapter2

    }
}