package ru.progpuppers.simmsearch.presentation.deviceMain.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.progpuppers.simmsearch.presentation.common.InputIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDrawer(
    onAddIconClick: () -> Unit,
    onMenuIconClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        ),
        navigationIcon = {
            InputIcon(
                onClick = onMenuIconClick,
                icon = Icons.Filled.Menu
            )
            Color.Gray
        },
        actions = {
            InputIcon(
                onClick = { onAddIconClick() },
                icon = Icons.Filled.Add
            )
        },
        title = { }
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarDrawerPreview() {
    TopBarDrawer(onAddIconClick = { }) { }
}
