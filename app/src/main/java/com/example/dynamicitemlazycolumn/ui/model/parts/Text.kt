package com.example.dynamicitemlazycolumn.ui.model.parts

import com.example.dynamicitemlazycolumn.ui.model.type.Type
import com.example.dynamicitemlazycolumn.ui.model.type.Align
import com.example.dynamicitemlazycolumn.ui.model.type.FontSize
import com.example.dynamicitemlazycolumn.ui.model.type.ItemColor

class Text(
    val message: String,
    val textAlign: Align = Align.CENTER,
    val textFont: FontSize = FontSize.DEFAULT,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.TEXT, alignment, weight, backgroundColor)