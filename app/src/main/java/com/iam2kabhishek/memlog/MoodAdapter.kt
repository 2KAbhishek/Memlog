package com.iam2kabhishek.memlog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MoodAdapter(private val context: Context, private val moods: List<MoodInfo>) :
    RecyclerView.Adapter<MoodAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_mood_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = moods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mood = moods[position]
        holder.textMoodIcon?.text = mood.name
        holder.textMoodTitle?.text = mood.id
        holder.moodPosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textMoodIcon = itemView.findViewById<TextView?>(R.id.textMoodIcon)
        val textMoodTitle = itemView.findViewById<TextView?>(R.id.textMoodTitle)
        var moodPosition = 0

        init {
            itemView.setOnClickListener{
//                val intent = Intent(context, EditMemory::class.java)
//                intent.putExtra(MEMORY_POSITION, memoryPosition)
//                context.startActivity(intent)
                Snackbar.make(it, moods[moodPosition].id, Snackbar.LENGTH_LONG).show()
            }
        }
    }

}
