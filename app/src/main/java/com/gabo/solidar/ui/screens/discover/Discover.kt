package com.gabo.solidar.ui.screens.discover

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabo.solidar.data.MockProjects
import com.gabo.solidar.ui.components.ProjectItem

@Composable
fun Discover() {
    val mockProjects = listOf(MockProjects.HUELLITAS, MockProjects.VIDA_EN_SANGRE, MockProjects.RESCATE_SOLIDARIO, MockProjects.RED_MAYOR, MockProjects.HUELLITAS)

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Barra buscador con filtros

        // Feed proyectos
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(mockProjects) { project ->
                ProjectItem(project.toProjectModel())
            }
        }
    }
}