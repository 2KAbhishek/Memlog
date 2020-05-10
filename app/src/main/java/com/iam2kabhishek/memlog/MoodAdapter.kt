package com.iam2kabhishek.memlog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoodAdapter(private val context: Context, private val moods: List<MoodInfo>) :
    RecyclerView.Adapter<MoodAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_mood_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = memories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val memory = memories[position]
        holder.textMood?.text = memory.mood?.name
        holder.textTitle?.text = memory.title
        holder.memoryPosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textMoodIcon = itemView.findViewById<TextView?>(R.id.textMoodIcon)
        val textMoodTitle = itemView.findViewById<TextView?>(R.id.textMoodTitle)
        var memoryPosition = 0

        init {
            itemView.setOnClickListener{
                val intent = Intent(context, EditMemory::class.java)
                intent.putExtra(MEMORY_POSITION, memoryPosition)
                context.startActivity(intent)
            }
        }
    }

}
