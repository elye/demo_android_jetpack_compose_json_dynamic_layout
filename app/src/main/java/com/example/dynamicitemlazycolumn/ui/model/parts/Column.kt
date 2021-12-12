package com.example.dynamicitemlazycolumn.ui.model.parts

import com.example.dynamicitemlazycolumn.ui.model.type.Align
import com.example.dynamicitemlazycolumn.ui.model.type.ItemColor
import com.example.dynamicitemlazycolumn.ui.model.type.Type

class Column(
    val listItems: List<ListItems>,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.COLUMN, alignment, weight, backgroundColor)