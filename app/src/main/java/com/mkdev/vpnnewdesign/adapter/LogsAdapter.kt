package com.mkdev.vpnnewdesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R

class LogsAdapter(
    private val items: MutableList<Int>,
    private val onItemClicked: ((Int) -> Unit)
) : RecyclerView.Adapter<LogsItemHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LogsItemHolder {
        return LogsItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(holder: LogsItemHolder, position: Int) {
        holder.bindView(
            items[position],
            onItemClicked
        )
    }

    override fun getItemCount(): Int = items.size
}