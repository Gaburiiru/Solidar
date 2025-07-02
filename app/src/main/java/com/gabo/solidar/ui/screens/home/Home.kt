package com.gabo.solidar.ui.screens.home

import PostModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.domain.type.AssistanceType
import com.gabo.solidar.ui.components.CardItem
import com.gabo.solidar.ui.components.Filter

@Composable
fun Home(post: List<PostModel>) {
    val filterData =
        mapOf(
            "Área de asistencia" to AssistanceArea.values().map { it.name },
            "Tipo de asistencia" to AssistanceType.values().map { it.name },
        )
    var selectedGroup by remember { mutableStateOf<String?>(null) }
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Filter(
                filterGroups = filterData,
                selectedGroup = selectedGroup,
                onFilterSelected = { group, option ->
                    selectedGroup = group
                },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(post) { pub ->
                CardItem(
                    post = pub,
                    following = { /* TODO */ },
                )
            }
        }
    }
}
