package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LogsItemHolder(
    private val viewItem: View
) : RecyclerView.ViewHolder(viewItem) {

    fun bindView(
        item: Int,
        clickListener: (Int) -> Unit
    ) {
        viewItem.apply {

        }
    }
}
