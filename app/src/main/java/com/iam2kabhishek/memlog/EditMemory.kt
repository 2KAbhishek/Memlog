package com.iam2kabhishek.memlog

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_memory.*
import kotlinx.android.synthetic.main.content_edit_memory.*
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi

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

        memoryPosition = savedInstanceState?.getInt(MEMORY_POSITION, POSITION_NOT_SET) ?:
            intent.getIntExtra(MEMORY_POSITION, POSITION_NOT_SET)

        if(memoryPosition != POSITION_NOT_SET)
            displayMemory()
        else {
            DataManager.memories.add(MemoryInfo())
            memoryPosition = DataManager.memories.lastIndex
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MEMORY_POSITION, memoryPosition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_next -> {
                moveNext()
                true
            }
            R.id.action_previous -> {
                movePrevious()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++memoryPosition
        displayMemory()
        invalidateOptionsMenu()
    }
    private fun movePrevious() {
        --memoryPosition
        displayMemory()
        invalidateOptionsMenu()
    }

    private fun displayMemory() {
       val memory = DataManager.memories[memoryPosition]
        textMemoryTitle.setText(memory.title)
        textMemoryDetails.setText(memory.details)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val menuItem : MenuItem?
        if (memoryPosition <= DataManager.memories.indexOf(DataManager.memories[0])) {
            menuItem = menu?.findItem(R.id.action_previous)
            if (menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24dp)
                menuItem.isEnabled = false
            }
        }
        else if (memoryPosition >= DataManager.memories.lastIndex){
            menuItem = menu?.findItem((R.id.action_next))
            if (menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24dp)
                menuItem.isEnabled = false
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        saveMemory()
        super.onPause()
    }

    private fun saveMemory() {
        val memory = DataManager.memories[memoryPosition]
        memory.title = textMemoryTitle.text.toString()
        memory.details = textMemoryDetails.text.toString()
        memory.mood = spinnerMoods.selectedItem as MoodInfo
    }
}
