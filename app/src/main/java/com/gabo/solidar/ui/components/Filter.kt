package com.gabo.solidar.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Filter(
    filterGroups: Map<String, List<String>>,
    selectedGroup: String?,
    onFilterSelected: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expandedGroup by remember { mutableStateOf<String?>(null) }

    LazyRow(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(filterGroups.keys.toList()) { group ->
            Box {
                FilterChip(
                    text = group,
                    selected = selectedGroup == group,
                    onClick = {
                        expandedGroup = if (expandedGroup == group) null else group
                    },
                )

                DropdownMenu(
                    expanded = expandedGroup == group,
                    onDismissRequest = { expandedGroup = null },
                ) {
                    filterGroups[group]?.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                onFilterSelected(group, option)
                                expandedGroup = null
                            },
                        )
                    }
                }
            }
        }
    }
}
