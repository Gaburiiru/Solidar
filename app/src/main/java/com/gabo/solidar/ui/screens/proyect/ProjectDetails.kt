package com.gabo.solidar.ui.screens.proyect

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.gabo.solidar.data.MockProjects
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.domain.type.ProjectState
import com.gabo.solidar.ui.navigation.NavigationRoutes
import com.gabo.solidar.ui.theme.LightBlue
import com.gabo.solidar.ui.theme.LightGreen
import com.gabo.solidar.ui.theme.LightMagenta
import com.gabo.solidar.ui.theme.LightRed
import com.gabo.solidar.ui.theme.LightYellow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun ProjectDetails(
    projectId: Long?,
    navController: NavController
) {
    val project = MockProjects.entries.find { projectId == it.id }
    if (project == null) {
        Text("No hay publicación seleccionada")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = project.logo,
                            contentDescription = "Logo de organización de ${project.organization}",
                            modifier =
                                Modifier
                                    .size(48.dp)
                                    .clip(CircleShape),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Column {
                            Text(project.organization)
                            Text(project.location)
                        }
                    }
                    OutlinedButton(onClick = { /* seguir */ }) {
                        Text(if (project.participating) "Dejar " else "Participar")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(project.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(project.activityDate, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(project.description, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(12.dp))

                AssistChip(
                    onClick = {},
                    label = { Text(project.state.n) },
                    colors =
                        AssistChipDefaults.assistChipColors(
                            containerColor =
                                when (project.state) {
                                    ProjectState.URGENT -> LightRed
                                    ProjectState.STARTING -> LightYellow
                                    ProjectState.ACTIVE -> LightGreen
                                },
                        ),
                )
                // TODO: Compartir proyecto
            }
        }
    }
}