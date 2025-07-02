package com.gabo.solidar.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gabo.solidar.data.MockProjects
import com.gabo.solidar.domain.model.ProjectModel
import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.domain.type.AssistanceType
import com.gabo.solidar.ui.theme.Blue
import com.gabo.solidar.ui.theme.Green
import com.gabo.solidar.ui.theme.LightBlue
import com.gabo.solidar.ui.theme.LightGreen
import com.gabo.solidar.ui.theme.LightMagenta
import com.gabo.solidar.ui.theme.LightRed
import com.gabo.solidar.ui.theme.LightYellow
import com.gabo.solidar.ui.theme.Yellow
import com.gabo.solidar.ui.theme.cardColor

@Composable
fun ProjectItem(project: ProjectModel) {
    Card(
        modifier =
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.75f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        model = project.logo,
                        contentDescription = "Logo Organización",
                        modifier =
                            Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = project.organization,
                        style =
                            MaterialTheme.typography.titleMedium.copy(
                                fontSize = 15.sp,
                            ),
                        modifier = Modifier.weight(1f),
                    )
                }
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector =
                            if (project.saved) {
                                Icons.Default.Bookmark
                            } else {
                                Icons.Default.BookmarkBorder
                            },
                        contentDescription = "Guardar",
                        tint = Green,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Título
            Row(
                modifier =
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
            ) {
                Text(
                    text = project.title,
                    style =
                        MaterialTheme.typography.titleMedium.copy(
                            fontSize = 25.sp,
                        ),
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción
            Row(
                modifier =
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
            ) {
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tags
            Row(
                modifier =
                    Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
            ) {
                AssistChip(
                    onClick = {},
                    label = { Text(project.assistanceArea.n) },
                    colors =
                        AssistChipDefaults.assistChipColors(
                            containerColor =
                                when (project.assistanceArea) {
                                    AssistanceArea.PEOPLE -> LightBlue
                                    AssistanceArea.ANIMALS -> LightYellow
                                    AssistanceArea.HUMANITARIAN_AID -> LightRed
                                    AssistanceArea.HUMAN_RIGHTS -> Color.White
                                    AssistanceArea.CLIMATE_CHANGE -> LightGreen
                                    AssistanceArea.SCIENCE -> LightMagenta
                                },
                        ),
                )
                Spacer(modifier = Modifier.width(12.dp))
                AssistChip(
                    onClick = {},
                    label = { Text(project.assistanceType.n) },
                    colors =
                        AssistChipDefaults.assistChipColors(
                            containerColor =
                                when (project.assistanceType) {
                                    AssistanceType.DONATION -> Green
                                    AssistanceType.VOLUNTARY -> Yellow
                                    AssistanceType.PROFESSIONAL -> Blue
                                },
                        ),
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            HorizontalDivider(color = Color.Black)
            Spacer(modifier = Modifier.height(6.dp))

            // Ubicación y fecha
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = project.location,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = project.activityDate,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProjectItem() {
    ProjectItem(MockProjects.HUELLITAS.toProjectModel())
}
