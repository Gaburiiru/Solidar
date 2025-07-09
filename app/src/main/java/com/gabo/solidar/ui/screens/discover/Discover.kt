package com.gabo.solidar.ui.screens.discover

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gabo.solidar.domain.model.ProjectModel
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.domain.type.AssistanceType
import com.gabo.solidar.ui.components.Filter
import com.gabo.solidar.ui.components.ProjectItem
import com.gabo.solidar.ui.components.SearchBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Discover(
    projects: List<ProjectModel>,
    navController: NavController,
) {
    val filterData =
        mapOf(
            "Área de asistencia" to AssistanceArea.entries.map { it.n },
            "Tipo de asistencia" to AssistanceType.entries.map { it.n },
            // TODO: Poner alerta de permitir ubicación
            "Ubicación" to emptyList(),
            "En Urgencia" to emptyList()
        )
    var selectedGroup by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Descubrir proyectos",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp)
                )
            })
        }
    ) {
        Column(modifier = Modifier.padding(top = 90.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                // Búsqueda
                SearchBar("", {}, {})

                // Filtros
                Filter(
                    filterGroups = filterData,
                    selectedGroup = selectedGroup,
                    onFilterSelected = { group, option ->
                        selectedGroup = group
                    }
                )

                // Feed proyectos
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF0F2F5)),
                ) {
                    items(projects) { project ->
                        ProjectItem(true, project, navController)
                    }
                }
            }
        }
    }
}
