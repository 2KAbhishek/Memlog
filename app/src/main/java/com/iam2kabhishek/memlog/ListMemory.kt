package com.iam2kabhishek.memlog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_list_memory.*
import kotlinx.android.synthetic.main.content_list_memory.*

class ListMemory : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private val memoryLayoutManager by lazy { LinearLayoutManager(this) }
    private val memoryAdapter by lazy { MemoryAdapter(this, DataManager.memories) }
    private val moodLayoutManager by lazy { GridLayoutManager(this, 2) }
    private val moodAdapter by lazy { MoodAdapter(this, DataManager.moods.values.toList() )}

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_memory)
            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)

            val fab: FloatingActionButton = findViewById(R.id.fab)
            fab.setOnClickListener { view ->
                startActivity(Intent(this, EditMemory::class.java))
            }

            displayMemory()

            val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            drawer_layout.addDrawerListener(toggle)
            toggle.syncState()

            nav_view.setNavigationItemSelectedListener(this)
        }

    private fun displayMemory() {
        listMemory.layoutManager = memoryLayoutManager
        listMemory.adapter = memoryAdapter

        nav_view.menu.findItem(R.id.nav_memory).isChecked = true
    }

    private fun displayMood() {
        listMemory.layoutManager = moodLayoutManager
        listMemory.adapter = moodAdapter

        nav_view.menu.findItem(R.id.nav_mood).isChecked = true
    }

    override fun onBackPressed() {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                (drawer_layout.closeDrawer(GravityCompat.START))
            } else {
                super.onBackPressed()
            }
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.list_memory, menu)
            return true
        }

        override fun onResume() {
            super.onResume()
            listMemory.adapter?.notifyDataSetChanged()
        }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.nav_memory -> {
                    displayMemory()
                }
                R.id.nav_mood -> {
                    displayMood()
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            return true
        }
}
