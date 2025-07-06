package com.gabo.solidar.ui.components

import PostModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.ui.navigation.NavigationRoutes
import com.gabo.solidar.ui.screens.home.PostSharedViewModel
import com.gabo.solidar.ui.theme.LightBlue
import com.gabo.solidar.ui.theme.LightGreen
import com.gabo.solidar.ui.theme.LightMagenta
import com.gabo.solidar.ui.theme.LightRed
import com.gabo.solidar.ui.theme.LightYellow
import com.gabo.solidar.ui.theme.cardColor

@Composable
fun CardItem(
    post: PostModel,
    navController: NavController,
) {
    val parentEntry =
        remember(navController) {
            navController.getBackStackEntry(NavigationRoutes.Home.route)
        }
    val sharedViewModel: PostSharedViewModel = viewModel(parentEntry)

    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
        onClick = {
            sharedViewModel.setPost(post)
            navController.navigate(NavigationRoutes.PostExperience.route)
        },
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Foto de perfil
                    AsyncImage(
                        model = post.profilePicture,
                        contentDescription = "Foto de perfil de ${post.author}",
                        modifier =
                            Modifier
                                .size(48.dp)
                                .clip(CircleShape),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = post.author,
                            style = MaterialTheme.typography.titleLarge,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            modifier = Modifier.width(150.dp),
                        )
                        Text(post.date, style = MaterialTheme.typography.bodySmall)
                    }
                }

                Button(onClick = {}) {
                    Text(if (post.following) "Siguiendo" else "Seguir")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(post.title, style = MaterialTheme.typography.titleSmall)
            Text(
                post.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(8.dp))

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

            Spacer(modifier = Modifier.height(8.dp))

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
        }
    }
}
