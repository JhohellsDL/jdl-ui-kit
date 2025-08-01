package com.jdlstudios.jdl_ui_kit.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FiltersChips(
    modifier: Modifier = Modifier,
    listOfFilters: List<String> = listOf("Even", "Random", "Preference"),
    initialSelectedFilter: String? = null,
    onFilterSelected: (String?) -> Unit = {}
) {
    var selectedFilter by remember { mutableStateOf(initialSelectedFilter) }

    LazyRow(
        modifier = modifier.background(Color(0xFF283039)),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(listOfFilters) { filtro ->
            val seleccionado = filtro == selectedFilter

            FilterChip(
                modifier = Modifier,
                selected = seleccionado,
                onClick = {
                    selectedFilter = if (seleccionado) null else filtro
                    onFilterSelected(selectedFilter)
                },
                label = {
                    Text(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        text = filtro,
                        color = if (seleccionado) Color.White else Color(0xFF9CAAB9)
                    )
                },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 0.dp,
                    color = Color.Transparent
                ),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color(0xFF283039),
                    selectedContainerColor = Color(0xFF121418),
                    labelColor = Color.White
                ),
                leadingIcon = {
                    if (seleccionado) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Seleccionado",
                            tint = Color(0xFF5FC2C3)
                        )
                    }
                }
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun InputChipPreview() {
    val listOfFilters = listOf("SOS", "SIS", "NON")
    FiltersChips(
        listOfFilters = listOfFilters,
        initialSelectedFilter = "SOS",
        onFilterSelected = { selected ->
            println("Filtro seleccionado: $selected")
        })
}