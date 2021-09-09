package com.example.composedemo1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo1.demo.*
import com.example.composedemo1.democomplexui.activity.DisplayTvShows
import com.example.composedemo1.democomplexui.activity.DisplayTvShowsActivity
import com.example.composedemo1.democomplexui.activity.LazyColumnDemoActivity
import com.example.composedemo1.democomplexui.activity.ScrollableColumnDemoActivity
import com.example.composedemo1.ui.theme.ComposeDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myCompose()
        }
    }


}

@Composable
fun myCompose() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        createButton("Modifier Demo") {
            val intent = Intent(context, ModifierActivity::class.java)
            context.startActivity(intent)
        }
        createButton("Row Demo") {
            val intent = Intent(context, RowActivity::class.java)
            context.startActivity(intent)
        }
        createButton("Column Demo") {
            val intent = Intent(context, ColumnActivity::class.java)
            context.startActivity(intent)
        }
        createButton("Box Demo") {
            val intent = Intent(context, BoxDemoActivity::class.java)
            context.startActivity(intent)
        }
        createButton("Button Demo") {
            val intent = Intent(context, ButtonDemoActivity::class.java)
            context.startActivity(intent)
        }
        createButton(name = "Scrollable Column Demo") {
            val intent = Intent(context, ScrollableColumnDemoActivity::class.java)
            context.startActivity(intent)
        }
        createButton(name = "Lazy Column Demo") {
            val intent = Intent(context, LazyColumnDemoActivity::class.java)
            context.startActivity(intent)
        }
        createButton(name = "Display Tv Shows") {
            val intent = Intent(context, DisplayTvShowsActivity::class.java)
            context.startActivity(intent)
        }
    }
}

@Composable
fun createButton(name: String, action: () -> Unit) {
    Box(Modifier.padding(10.dp)) {
        TextButton(onClick = { action.invoke() }) {
            Text(
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .background(Color.Green)
                    .padding(10.dp)
                    .defaultMinSize(200.dp),
                text = name,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemo1Theme {
        myCompose()
    }
}






