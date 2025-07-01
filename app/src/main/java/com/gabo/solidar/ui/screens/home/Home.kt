package com.gabo.solidar.ui.screens.home

import PostModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.gabo.solidar.ui.components.CardItem

@Composable
fun Home(post: List<PostModel>) {
    LazyColumn {
        items(post) { pub ->
            CardItem(
                post = pub, following = { /* TODO */ },
            )
        }
    }
}
