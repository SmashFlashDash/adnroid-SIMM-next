package ru.progpuppers.simmsearch.presentation.deviceSelect.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerItemsState(val drawerItems: List<DrawerItem>) {
    data object MenuState : DrawerItemsState(
        listOf(
            DrawerItem(Icons.Filled.DataArray , "Manage data"),
            DrawerItem(Icons.Filled.Analytics , "Explore data"),
            DrawerItem(Icons.Filled.NearMe , "Navigation map"),
            DrawerItem(Icons.Filled.Settings, "Settings")
        )
    )
}

data class DrawerItem(val icon: ImageVector, val text: String)