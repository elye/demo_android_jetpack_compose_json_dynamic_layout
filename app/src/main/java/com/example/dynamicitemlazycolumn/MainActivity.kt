package com.example.dynamicitemlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dynamicitemlazycolumn.ui.theme.DynamicItemLazyColumnTheme
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Payload(val listItems: List<ListItems>)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moshi = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(ListItems::class.java, "type")
                    .withSubtype(Text::class.java, Type.TEXT.name)
                    .withSubtype(Button::class.java, Type.BUTTON.name)
                    .withSubtype(Image::class.java, Type.IMAGE.name)
                    .withSubtype(Row::class.java, Type.ROW.name)
                    .withSubtype(Column::class.java, Type.COLUMN.name)
                    .withDefaultValue(
                        Text(
                            "Oh, what's that?",
                            backgroundColor = ItemColor.RED
                        )
                    )
            )
            .add(KotlinJsonAdapterFactory())
            .build()

        val adapter: JsonAdapter<Payload> = moshi.adapter(Payload::class.java)

        adapter.fromJson(payloadMany)?.let{
            setContent {
                DynamicItemLazyColumnTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        Greeting(payload = it)
                    }
                }
            }
        }
    }
}

class Text(
    val message: String,
    val textAlign: Align = Align.CENTER,
    val textFont: FontSize = FontSize.DEFAULT,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.TEXT, alignment, weight, backgroundColor)

class Button(
    val message: String,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.BUTTON, alignment, weight, backgroundColor)

class Image(
    val imageAlign: Align = Align.CENTER,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.IMAGE, alignment, weight, backgroundColor)

class Column(
    val listItems: List<ListItems>,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.COLUMN, alignment, weight, backgroundColor)

class Row(
    val listItems: List<ListItems>,
    alignment: Align = Align.CENTER,
    weight: Float = 0f,
    backgroundColor: ItemColor = ItemColor.NONE
) : ListItems(Type.ROW, alignment, weight, backgroundColor)

sealed class ListItems(
    val type: Type,
    val alignment: Align = Align.NONE,
    val weight: Float = 0f,
    val backgroundColor: ItemColor = ItemColor.NONE
)

enum class Type {
    TEXT,
    BUTTON,
    IMAGE,
    COLUMN,
    ROW
}

enum class ItemColor {
    NONE,
    RED,
    GREEN,
    BLUE
}

enum class FontSize {
    TINY,
    SMALL,
    DEFAULT,
    BIG,
    HUGE
}

enum class Align {
    NONE,
    START,
    CENTER,
    END,
    FILL
}

@Composable
fun Greeting(payload: Payload) {
    val dynamicListItem = payload.listItems
    Box(modifier = Modifier.padding(4.dp, 4.dp, 4.dp)) {
        LazyColumn {
            items(dynamicListItem.size) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                        .background(Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    constructPart(
                        dynamicListItem[index],
                        createModifier(dynamicListItem[index])
                    )
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.createModifier(
    listItems: ListItems
): Modifier {
    var modifier = if (listItems.weight > 0) {
        Modifier.weight(listItems.weight)
    } else Modifier

    modifier = commonModifier(modifier, listItems)

    return when (listItems.alignment) {
        Align.START -> modifier.align(Alignment.Start)
        Align.END -> modifier.align(Alignment.End)
        Align.CENTER -> modifier.align(Alignment.CenterHorizontally)
        Align.FILL -> modifier.fillMaxWidth()
        else -> modifier
    }
}

@Composable
private fun commonModifier(
    modifier: Modifier,
    listItems: ListItems
): Modifier {
    var modifier1 = modifier
    modifier1 = if (listItems.backgroundColor == ItemColor.RED) {
        modifier1.background(Color.Red)
    } else if (listItems.backgroundColor == ItemColor.GREEN) {
        modifier1.background(Color.Green)
    } else if (listItems.backgroundColor == ItemColor.BLUE) {
        modifier1.background(Color.Blue)
    } else {
        modifier1
    }
    return modifier1
}

@Composable
private fun RowScope.createModifier(
    listItems: ListItems
): Modifier {

    var modifier = if (listItems.weight > 0) {
        Modifier.weight(listItems.weight)
    } else Modifier

    modifier = commonModifier(modifier, listItems)

    return when (listItems.alignment) {
        Align.START -> modifier.align(Alignment.Top)
        Align.END -> modifier.align(Alignment.Bottom)
        Align.CENTER -> modifier.align(Alignment.CenterVertically)
        Align.FILL -> modifier.fillMaxHeight()
        else -> modifier
    }
}

@Composable
private fun constructPart(
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
                    constructPart(item, createModifier(item))
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
                    constructPart(item, createModifier(item))
                }
            }
        }
    }
}
