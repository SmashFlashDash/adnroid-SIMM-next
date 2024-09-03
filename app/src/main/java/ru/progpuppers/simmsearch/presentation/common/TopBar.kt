package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onExtendClick: () -> Unit,
    onBackClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(),
        navigationIcon = {
            InputIcon(
                onClick = onBackClick,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                description = "navigation back",
                tint = Color.Black
            )
        },
        actions = {
            InputIcon(
                onClick = onExtendClick,
                icon = Icons.Filled.MoreVert,
                description = "extend",
                tint = Color.Black
            )
        },
        title = { },
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar (
        onExtendClick = { },
        onBackClick = { }
    )
}