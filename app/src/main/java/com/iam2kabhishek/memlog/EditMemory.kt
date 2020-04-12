package com.iam2kabhishek.memlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_memory.*
import kotlinx.android.synthetic.main.content_edit_memory.*
import android.widget.ArrayAdapter

class EditMemory : AppCompatActivity() {

    private  var memoryPosition = POSITION_NOT_SET
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_memory)
        setSupportActionBar(toolbar)

        val adapterMoods = ArrayAdapter<MoodInfo>(this, android.R.layout.simple_spinner_item,
            DataManager.moods.values.toList())
        adapterMoods.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMoods.adapter = adapterMoods

        memoryPosition = intent.getIntExtra(MEMORY_POSITION, POSITION_NOT_SET)

        if(memoryPosition != POSITION_NOT_SET)
            displayMemory()
    }

    private fun displayMemory() {
       val memory = DataManager.memories[memoryPosition]
        textMemoryTitle.setText(memory.title)
        textMemoryDetails.setText(memory.details)
    }

}
