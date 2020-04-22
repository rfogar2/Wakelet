package com.example.wakelet.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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

    class PhotographViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: PhotographViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
