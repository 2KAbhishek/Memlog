package com.iam2kabhishek.memlog

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_next -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayMemory() {
       val memory = DataManager.memories[memoryPosition]
        textMemoryTitle.setText(memory.title)
        textMemoryDetails.setText(memory.details)
    }

}
