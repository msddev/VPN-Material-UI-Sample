package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R
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

            if (item.title == context.getString(R.string.header_active_connection)) {
                activeConnectionTitle.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_green_light
                    )
                )
                /*activeConnectionTitle.setIconResource(R.drawable.ic_baseline_check_circle_24)
                activeConnectionTitle.setIconTintResource(R.color.color_green_light)*/
            } else {
                activeConnectionTitle.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_pink_light
                    )
                )
                /*activeConnectionTitle.setIconResource(R.drawable.ic_baseline_cancel_24)
                activeConnectionTitle.setIconTintResource(R.color.color_pink_light)*/
            }
        }
    }
}
