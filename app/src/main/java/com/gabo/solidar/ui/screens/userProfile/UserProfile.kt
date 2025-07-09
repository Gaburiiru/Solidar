package com.gabo.solidar.ui.screens.userProfile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.gabo.solidar.data.MockUser
import com.gabo.solidar.ui.components.PostItem
import com.gabo.solidar.ui.navigation.NavigationRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") },
            )
        },
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
        ) {
            item {
                Column(
                    modifier =
                        Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .background(Color.Gray),
                    ) {
                        AsyncImage(
                            model = "https://randomuser.me/api/portraits/women/3.jpg",
                            contentDescription = "Foto de perfil",
                            modifier =
                                Modifier
                                    .size(80.dp)
                                    .clip(CircleShape),
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Sofía Méndez", style = MaterialTheme.typography.titleLarge)

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text("2 publicaciones")
                        Text("2 seguidores")
                        Text("2 seguidos")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        navController.navigate(NavigationRoutes.EditUserProfile.route)
                    }) {
                        Text("Edit")
                    }
                }
            }

            items(MockUser.entries.toTypedArray()) { mock ->
                PostItem(
                    post = mock.toPostModel(),
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 6.dp),
                )
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}
