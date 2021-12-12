package com.example.dynamicitemlazycolumn.ui.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.dynamicitemlazycolumn.R
import com.example.dynamicitemlazycolumn.ui.model.parts.*
import com.example.dynamicitemlazycolumn.ui.model.type.Align
import com.example.dynamicitemlazycolumn.ui.model.type.FontSize
import com.example.dynamicitemlazycolumn.ui.model.type.Type
import com.example.dynamicitemlazycolumn.ui.model.utils.createModifier

@Composable
fun ConstructPart(
    listItems: ListItems,
    modifier: Modifier = Modifier
) {
    when (listItems.type) {
        Type.TEXT -> {
            val text = (listItems as Text).message
            val textAlign = when (listItems.textAlign) {
                Align.START -> TextAlign.Start
                Align.END -> TextAlign.End
                Align.CENTER -> TextAlign.Center
                else -> null
            }
            val fontSize = when (listItems.textFont) {
                FontSize.TINY -> 8.sp
                FontSize.SMALL -> 12.sp
                FontSize.BIG -> 20.sp
                FontSize.HUGE -> 24.sp
                else -> 16.sp
            }
            Text(
                text = text,
                modifier = modifier,
                textAlign = textAlign,
                fontSize = fontSize
            )
        }
        Type.BUTTON -> {
            val text = (listItems as Button).message
            Button(onClick = { /*TODO*/ }, modifier = modifier) {
                Text(text = text)
            }
        }
        Type.IMAGE -> {
            val imageAlign = when ((listItems as Image).imageAlign) {
                Align.START -> Alignment.TopStart
                Align.END -> Alignment.BottomEnd
                else -> Alignment.Center
            }
            val image: Painter = painterResource(id = R.drawable.ic_launcher_foreground)
            Image(image, "", modifier = modifier, alignment = imageAlign)
        }
        Type.COLUMN -> {
            val items = (listItems as Column).listItems
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                for (item in items) {
                    ConstructPart(item, createModifier(item))
                }
            }
        }
        Type.ROW -> {
            val items = (listItems as Row).listItems
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {
                for (item in items) {
                    ConstructPart(item, createModifier(item))
                }
            }
        }
    }
}
