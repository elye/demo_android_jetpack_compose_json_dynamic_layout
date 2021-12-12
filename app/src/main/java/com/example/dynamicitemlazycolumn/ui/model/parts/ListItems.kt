package com.example.dynamicitemlazycolumn.ui.model.parts

import com.example.dynamicitemlazycolumn.ui.model.type.Align
import com.example.dynamicitemlazycolumn.ui.model.type.ItemColor
import com.example.dynamicitemlazycolumn.ui.model.type.Type

sealed class ListItems(
    val type: Type,
    val alignment: Align = Align.NONE,
    val weight: Float = 0f,
    val backgroundColor: ItemColor = ItemColor.NONE
)