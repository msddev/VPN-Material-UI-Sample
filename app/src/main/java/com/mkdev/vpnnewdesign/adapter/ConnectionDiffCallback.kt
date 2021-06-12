package com.mkdev.vpnnewdesign.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mkdev.vpnnewdesign.models.ConnectionModel

class ConnectionDiffCallback(
    private val oldList: List<ConnectionModel>,
    private val newList: List<ConnectionModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].isSelected == newList[newItemPosition].isSelected
    }
}
