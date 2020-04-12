package com.iam2kabhishek.memlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_memory.*

class EditMemory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_memory)
        setSupportActionBar(toolbar)
    }

}
