package com.example.wakelet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wakelet.R
import com.example.wakelet.models.Photograph

class PhotographAdapter(
    val onClick: (Photograph) -> Unit
) : ListAdapter<Photograph, PhotographAdapter.PhotographViewHolder>(PhotographCallback()) {
    class PhotographCallback : DiffUtil.ItemCallback<Photograph>() {
        override fun areItemsTheSame(oldItem: Photograph, newItem: Photograph): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Photograph, newItem: Photograph): Boolean =
            oldItem == newItem
    }

    class PhotographViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_photograph_item, parent, false)
        return PhotographViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotographViewHolder, position: Int) {
        val item = getItem(position)

        holder.description.text = item.description
    }
}
