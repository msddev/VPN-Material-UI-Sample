package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.list_item.view.*

class ConnectionsHolder(
    private val viewItem: View
) : RecyclerView.ViewHolder(viewItem) {

    fun bindTo(item: ConnectionModel, itemsCount: Int, clickListener: (Int) -> Unit) {
        viewItem.apply {
            connectionName.text = "Connection$adapterPosition"

            expandableView.isVisible = item.isSelected

            line.isVisible = adapterPosition != itemsCount - 1

            itemRoot.setOnClickListener {
                clickListener(adapterPosition)
            }
        }
    }
}
