package com.mkdev.vpnnewdesign.models

data class ConnectionModel(
    var isSelected: Boolean = false,
    var isActive: Boolean = false,
    val data: Int = 0,
    val name: String = ""
)
