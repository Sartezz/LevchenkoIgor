package com.example.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<Entity>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item:Entity, click: (Entity) -> Unit)
}