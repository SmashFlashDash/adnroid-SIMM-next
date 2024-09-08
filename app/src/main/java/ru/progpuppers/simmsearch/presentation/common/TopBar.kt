package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onExtendClick: () -> Unit,
    onBackClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        ),
        navigationIcon = {
            InputIcon(
                onClick = onBackClick,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                description = "navigation back"
            )
        },
        actions = {
            InputIcon(
                onClick = onExtendClick,
                icon = Icons.Filled.MoreVert,
                description = "extend"
            )
        },
        title = { },
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(
        onExtendClick = { },
        onBackClick = { }
    )
}