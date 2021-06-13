package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.list_item.view.*

class ConnectionsHolder(
    private val viewItem: View
) : RecyclerView.ViewHolder(viewItem) {

    fun bindTo(
        item: ConnectionModel,
        itemsCount: Int,
        clickListener: (Int) -> Unit,
        onItemActivationClicked: (Int) -> Unit
    ) {
        viewItem.apply {
            connectionName.text = item.title
            expandableView.isVisible = item.isSelected
            line.isVisible = adapterPosition != itemsCount - 1

            if (item.isActive) {
                activeConnectionButton.text = "Active Connection"
                activeConnectionButton.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_green_light
                    )
                )
                activeConnectionButton.setIconResource(R.drawable.ic_baseline_check_circle_24)
                activeConnectionButton.setIconTintResource(R.color.color_green_light)
                statusLine.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_green_light
                    )
                )
            } else {
                activeConnectionButton.text = "Connection Activation"
                activeConnectionButton.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_pink_light
                    )
                )
                activeConnectionButton.setIconResource(R.drawable.ic_baseline_cancel_24)
                activeConnectionButton.setIconTintResource(R.color.color_pink_light)
                statusLine.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_pink_light
                    )
                )
            }

            itemRoot.setOnClickListener {
                clickListener(adapterPosition)
            }

            activeConnectionButton.setOnClickListener {
                onItemActivationClicked(adapterPosition)
            }
        }
    }
}
