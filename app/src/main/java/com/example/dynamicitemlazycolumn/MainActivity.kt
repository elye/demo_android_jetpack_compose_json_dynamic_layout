package com.example.dynamicitemlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dynamicitemlazycolumn.ui.model.ConstructPart
import com.example.dynamicitemlazycolumn.ui.model.parts.ListItems
import com.example.dynamicitemlazycolumn.ui.model.utils.createModifier
import com.example.dynamicitemlazycolumn.ui.theme.DynamicItemLazyColumnTheme
import com.squareup.moshi.JsonAdapter

class Payload(val listItems: List<ListItems>)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadPayload()?.let{
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
                    ConstructPart(
                        dynamicListItem[index],
                        createModifier(dynamicListItem[index])
                    )
                }
            }
        }
    }
}

