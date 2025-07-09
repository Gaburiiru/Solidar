package com.gabo.solidar.ui.screens.proyect

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gabo.solidar.domain.model.ProjectModel
import com.gabo.solidar.domain.type.ProjectState
import com.gabo.solidar.ui.components.Filter
import com.gabo.solidar.ui.components.ProjectItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Proyect(
    projects: List<ProjectModel>,
    navController: NavController,
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Participando", "Guardados")
    val filterData =
        mapOf(
            "Fecha de Actividad" to emptyList(),
            "Estado" to ProjectState.entries.map { it.n },
        )
    var selectedGroup by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier =
                            Modifier
                                .fillMaxWidth(),
                        text = "Proyectos guardados",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp),
                    )
                },
            )
        },
    ) {
        Column(modifier = Modifier.padding(top = 90.dp)) {
            Column {
                TabRow(modifier = Modifier.fillMaxWidth(), selectedTabIndex = selectedTabIndex) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = {
                                selectedTabIndex = index
                            },
                            text = {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                                )
                            },
                        )
                    }
                }
                val filteredProjects =
                    when (selectedTabIndex) {
                        0 -> projects.filter { it.participating }
                        1 -> projects.filter { it.saved }
                        else -> projects
                    }
                Column {
                    Filter(
                        filterGroups = filterData,
                        selectedGroup = selectedGroup,
                        onFilterSelected = { group, option ->
                            selectedGroup = group
                        },
                    )
                }

                // Feed Proyectos
                LazyColumn(
                    modifier =
                        Modifier
                            .background(Color(0xFFF0F2F5)),
                ) {
                    items(filteredProjects) { project ->
                        ProjectItem(false, project, navController)
                    }
                }
            }
        }
    }
}
