package com.mkdev.vpnnewdesign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R
import com.mkdev.vpnnewdesign.enums.ItemViewType
import com.mkdev.vpnnewdesign.models.ConnectionModel

class ConnectionsAdapter(
    private val items: MutableList<ConnectionModel>,
    private val onItemClicked: ((Int) -> Unit),
    private val onItemActivationClicked: ((Int) -> Unit),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemViewType.HEADER.ordinal -> {
                ConnectionsHeaderHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.list_header,
                        parent,
                        false
                    ),
                )
            }
            else -> {
                ConnectionsItemHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.list_item,
                        parent,
                        false
                    ),
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ConnectionsHeaderHolder -> {
                holder.bindView(items[position])
            }
            is ConnectionsItemHolder -> {
                holder.bindView(items[position], itemCount, onItemClicked, onItemActivationClicked)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return if (items[position].isHeader) {
            ItemViewType.HEADER.ordinal
        } else {
            ItemViewType.ITEM.ordinal
        }
    }
}