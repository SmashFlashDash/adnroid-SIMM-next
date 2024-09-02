package ru.progpuppers.simmsearch.presentation.deviceSelect.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
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
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.presentation.common.NotAvailablePopUpState
import ru.progpuppers.simmsearch.presentation.common.NotAvailablePopup
import ru.progpuppers.simmsearch.presentation.common.isVisible


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDrawer(
    onAddIconClick: () -> Unit,
    onMenuIconClick: () -> Unit
) {
    // show notImplemented Dialog
    var notAvailablePopupState by rememberSaveable {
        mutableStateOf(
            NotAvailablePopUpState.GONE
        )
    }
    if (notAvailablePopupState.isVisible()) {
        NotAvailablePopup { notAvailablePopupState = NotAvailablePopUpState.GONE }
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            // containerColor = MaterialTheme.colorScheme.primaryContainer,
            // titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            InputIcon(
                onClick = onMenuIconClick,
                icon = Icons.Filled.Menu,
                description = "navigation menu",
                tint = Color.Black
            )
        },
        actions = {
            InputIcon(
                onClick = { onAddIconClick() },
                // onClick = { notAvailablePopupVisibility = NotAvailablePopUpState.VISIBLE },
                icon = Icons.Filled.Add,
                description = "add device",
                tint = Color.Black
            )
        },
        title = { }
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarDrawerPreview() {
    TopBarDrawer (onAddIconClick = { }) { }
}
