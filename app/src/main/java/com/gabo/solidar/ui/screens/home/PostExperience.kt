package com.gabo.solidar.ui.screens.home

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.ui.navigation.NavigationRoutes
import com.gabo.solidar.ui.theme.LightBlue
import com.gabo.solidar.ui.theme.LightGreen
import com.gabo.solidar.ui.theme.LightMagenta
import com.gabo.solidar.ui.theme.LightRed
import com.gabo.solidar.ui.theme.LightYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostExperience(navController: NavController) {
    val parentEntry =
        remember(navController) {
            navController.getBackStackEntry(NavigationRoutes.Home.route)
        }
    val sharedViewModel: PostSharedViewModel = viewModel(parentEntry)

    val post = sharedViewModel.selectedPost.value
    if (post == null) {
        Text("No hay publicación seleccionada")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(NavigationRoutes.Home.route) }) {
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
                    .fillMaxSize().verticalScroll(rememberScrollState()),
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
                            model = post.profilePicture,
                            contentDescription = "Foto de perfil de ${post.author}",
                            modifier =
                                Modifier
                                    .size(48.dp)
                                    .clip(CircleShape),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Column {
                            Text(post.author)
                            Text(post.date, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    OutlinedButton(onClick = { /* seguir */ }) {
                        Text(if (post.following) "Siguiendo" else "Seguir")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(post.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(post.description, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(12.dp))

                AssistChip(
                    onClick = {},
                    label = { Text(post.organization) },
                    colors =
                        AssistChipDefaults.assistChipColors(
                            containerColor =
                                when (post.assistanceArea) {
                                    AssistanceArea.PEOPLE -> LightBlue
                                    AssistanceArea.ANIMALS -> LightYellow
                                    AssistanceArea.HUMANITARIAN_AID -> LightRed
                                    AssistanceArea.HUMAN_RIGHTS -> Color.White
                                    AssistanceArea.CLIMATE_CHANGE -> LightGreen
                                    AssistanceArea.SCIENCE -> LightMagenta
                                },
                        ),
                )

                Spacer(modifier = Modifier.height(12.dp))

                AsyncImage(
                    model = post.pictures,
                    contentDescription = "Foto de de ${post.author}",
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp)),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Likes",
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = post.likes.toString())
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.ChatBubble,
                            contentDescription = "Comments",
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = post.comments.toString())
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Shares",
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = post.shared.toString())
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))

                // Comentarios mock
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = "https://randomuser.me/api/portraits/men/91.jpg",
                            contentDescription = "Foto de perfil de juan",
                            modifier =
                                Modifier
                                    .size(30.dp)
                                    .clip(CircleShape),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Column {
                            Text("juan Perez", style = MaterialTheme.typography.bodyMedium)
                            Text("¡Wou que interesante!", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
