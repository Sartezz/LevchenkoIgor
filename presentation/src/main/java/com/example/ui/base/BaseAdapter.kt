package com.example.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : BaseViewHolder<Entity>, Entity> : RecyclerView.Adapter<VH>() {
    private val list: MutableList<Entity> = ArrayList()
    lateinit var onClick: (Entity) -> Unit

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position]) {
            onClick(it)
        }
    }

    fun addItems(list: List<Entity>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: Entity) {
        this.list.add(item)
        notifyDataSetChanged()
    }
}