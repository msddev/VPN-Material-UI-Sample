package com.mkdev.vpnnewdesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R
import com.mkdev.vpnnewdesign.models.ConnectionModel

class ConnectionsAdapter(
    private val dataList: MutableList<ConnectionModel>,
    private val onItemClicked: ((Int) -> Unit)
) : RecyclerView.Adapter<ConnectionsHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ConnectionsHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    )

    override fun onBindViewHolder(holder: ConnectionsHolder, position: Int) {
        holder.bindTo(dataList[position], itemCount, onItemClicked)
    }

    override fun getItemCount(): Int = dataList.size

    fun updateData(newItems: List<ConnectionModel>) {
        val result = DiffUtil.calculateDiff(ConnectionDiffCallback(dataList, newItems))
        result.dispatchUpdatesTo(this)

        dataList.clear()
        dataList.addAll(newItems)
    }
}