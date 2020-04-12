package com.iam2kabhishek.memlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_memory.*
import kotlinx.android.synthetic.main.content_edit_memory.*
import android.widget.ArrayAdapter as ArrayAdapter1

class EditMemory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_memory)
        setSupportActionBar(toolbar)
        
        val dm = DataManager()
        val adapterMoods = ArrayAdapter1<MoodInfo>(this, android.R.layout.simple_spinner_item, dm.moods.values.toList())
        adapterMoods.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMoods.adapter = adapterMoods
        
    }

}
