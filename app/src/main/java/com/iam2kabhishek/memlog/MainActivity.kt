package com.iam2kabhishek.memlog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
          val addMemoryIntent = Intent(this, EditMemory::class.java)
            startActivity(addMemoryIntent)
        }
        listMemories.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume(){
        super.onResume()

    }

}

