package com.iam2kabhishek.memlog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoryAdapter(private val context: Context, private val memories: List<MemoryInfo>) :
    RecyclerView.Adapter<MemoryAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_memory_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = memories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val memory = memories[position]
        holder.textMood?.text = memory.mood?.name
        holder.textTitle?.text = memory.title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textMood = itemView.findViewById<TextView?>(R.id.textMood)
        val textTitle = itemView.findViewById<TextView?>(R.id.textMemTitle)
    }

}