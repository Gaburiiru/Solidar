package com.gabo.solidar.ui.screens.post

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabo.solidar.ui.theme.BackgroundColor
import com.gabo.solidar.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Post(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 0.dp)
                .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        // Card principal que contiene todo
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(containerColor = cardColor),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                // Campo de Título
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Card para la descripción
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors =
                        CardDefaults.cardColors(
                            containerColor = BackgroundColor,
                        ),
                ) {
                    Text(
                        text = "Descripción",
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                                .padding(top = 10.dp, start = 10.dp),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tres Cards para las acciones
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                    // Espacio inferior
                    horizontalArrangement = Arrangement.Start, // Centrado horizontal
                    verticalAlignment = Alignment.Bottom, // Alineado al fondo
                ) {
                    // Card para foto

                    ActionCard(
                        icon = Icons.Default.PhotoCamera,
                        height = 100,
                        width = 100,
                        onClick = { /* Acción foto */ },
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    // Card para mencionar
                    ActionCard(
                        icon = Icons.Default.PersonAdd,
                        height = 40,
                        width = 40,
                        onClick = { /* Acción mencionar */ },
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    // Card para ubicación
                    ActionCard(
                        icon = Icons.Default.LocationOn,
                        height = 40,
                        width = 40,
                        onClick = { /* Acción ubicación */ },
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botones inferiores
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    OutlinedButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.padding(end = 8.dp),
                    ) {
                        Text("Cancelar")
                    }

                    Button(
                        onClick = { /* Acción de agregar */ },
                        enabled = title.isNotEmpty() && description.isNotEmpty(),
                    ) {
                        Text("Agregar")
                    }
                }
            }
        }
    }
}

@Composable
fun ActionCard(
    icon: ImageVector,
    width: Int,
    height: Int,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier =
            Modifier
                .width(width.dp)
                .height(height.dp),
        shape = MaterialTheme.shapes.medium,
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "icon",
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}
