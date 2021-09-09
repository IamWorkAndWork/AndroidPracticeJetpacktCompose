package com.example.composedemo1.democomplexui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.composedemo1.democomplexui.compose.TvShowListItem
import com.example.composedemo1.democomplexui.data.TvShowList
import com.example.composedemo1.democomplexui.model.TvShow

class DisplayTvShowsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            createUI()
        }

    }


}

@Preview(showBackground = true)
@Composable
private fun createUI() {
    val context = LocalContext.current
    DisplayTvShows() { tvShow ->
        val intent = InfoActivity.intent(context, tvShow)
        context.startActivity(intent)
    }
}

@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {

    val tvShows = remember {
        TvShowList.tvShows
    }

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(items = tvShows,
            itemContent = { tvShow ->
                TvShowListItem(tvShow = tvShow, selectedItem = selectedItem)
            })
    }

}