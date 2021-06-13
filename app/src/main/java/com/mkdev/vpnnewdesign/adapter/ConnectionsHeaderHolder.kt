package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.list_header.view.*

class ConnectionsHeaderHolder(
    private val viewItem: View
) : RecyclerView.ViewHolder(viewItem) {

    fun bindView(
        item: ConnectionModel,
    ) {
        viewItem.apply {
            activeConnectionTitle.text = item.title
        }
    }
}
