package com.gabo.solidar.ui.screens.home

import PostModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabo.solidar.ui.components.CardItem

@Composable fun Home(
    posts: List<PostModel>,
    navController: NavController,
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Para ti", "Seguidos")
    Column {
        TabRow(modifier = Modifier.fillMaxWidth().padding(top = 50.dp), selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(title) },
                )
            }
        }
        val filteredPosts =
            when (selectedTabIndex) {
                0 -> posts // "Para ti":todos

                1 -> posts.filter { it.following == true } // "Seguidos"
                else -> posts
            }
        LazyColumn(
            modifier =
                Modifier
                    .background(Color(0xFFF0F2F5)),
        ) {
            items(filteredPosts) { post ->
                CardItem(post, navController)
            }
        }
    }
}
