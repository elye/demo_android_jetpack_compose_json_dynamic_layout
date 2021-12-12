package com.example.dynamicitemlazycolumn

import com.example.dynamicitemlazycolumn.ui.model.parts.Button
import com.example.dynamicitemlazycolumn.ui.model.parts.Image
import com.example.dynamicitemlazycolumn.ui.model.parts.ListItems
import com.example.dynamicitemlazycolumn.ui.model.parts.Text
import com.example.dynamicitemlazycolumn.ui.model.type.ItemColor
import com.example.dynamicitemlazycolumn.ui.model.type.Type
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun loadPayload(jsonPayload: String): Payload? {
    val moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(ListItems::class.java, "type")
                .withSubtype(Text::class.java, Type.TEXT.name)
                .withSubtype(Button::class.java, Type.BUTTON.name)
                .withSubtype(Image::class.java, Type.IMAGE.name)
                .withSubtype(
                    com.example.dynamicitemlazycolumn.ui.model.parts.Row::class.java,
                    Type.ROW.name
                )
                .withSubtype(
                    com.example.dynamicitemlazycolumn.ui.model.parts.Column::class.java,
                    Type.COLUMN.name
                )
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
    return adapter.fromJson(jsonPayload)
}
