package com.example.wakelet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
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
        val container: ConstraintLayout = itemView.findViewById(R.id.container)
        val description: TextView = itemView.findViewById(R.id.description)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_photograph_item, parent, false)
        return PhotographViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotographViewHolder, position: Int) {
        val photograph = getItem(position)

        holder.container.setOnClickListener { onClick(photograph) }
        holder.description.text = photograph.description

        Glide.with(holder.image.context)
            .load(photograph.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.image)
    }
}
