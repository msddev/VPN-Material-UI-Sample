package com.mkdev.vpnnewdesign.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mkdev.vpnnewdesign.R
import com.mkdev.vpnnewdesign.enums.ItemModifyType
import com.mkdev.vpnnewdesign.extensionFun.gone
import com.mkdev.vpnnewdesign.extensionFun.visible
import com.mkdev.vpnnewdesign.models.ConnectionModel
import kotlinx.android.synthetic.main.list_item.view.*

class ConnectionsItemHolder(
    private val viewItem: View
) : RecyclerView.ViewHolder(viewItem) {

    fun bindView(
        item: ConnectionModel,
        itemsCount: Int,
        clickListener: (Int) -> Unit,
        onItemModifyClicked: (Int, ItemModifyType) -> Unit
    ) {
        viewItem.apply {
            connectionName.text = item.title
            expandableView.isVisible = item.isSelected
            line.isVisible = adapterPosition != itemsCount - 1

            if (item.isActive) {
                activeConnectionButton.gone()
                statusLine.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_green_light
                    )
                )
            } else {
                activeConnectionButton.visible()
                activeConnectionButton.text = context.getString(R.string.activation)
                activeConnectionButton.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_green_light
                    )
                )
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
                onItemModifyClicked(adapterPosition, ItemModifyType.CHANGE_CONNECTION)
            }

            editNameButton.setOnClickListener {
                onItemModifyClicked(adapterPosition, ItemModifyType.EDIT)
            }

            deleteButton.setOnClickListener {
                onItemModifyClicked(adapterPosition, ItemModifyType.DELETE)
            }

            credentialButton.setOnClickListener {
                onItemModifyClicked(adapterPosition, ItemModifyType.CREDENTIAL)
            }
        }
    }
}
