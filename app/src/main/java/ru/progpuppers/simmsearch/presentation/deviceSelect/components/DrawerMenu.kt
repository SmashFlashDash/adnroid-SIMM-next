package ru.progpuppers.simmsearch.presentation.deviceSelect.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun DrawerSheet(uiState: DrawerItemsState) {
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(24.dp))
        uiState.drawerItems.forEach { item ->
            DrawerMenuItem(imageVector = item.icon, text = item.text)
        }
    }
}

@Composable
private fun DrawerMenuItem(
    imageVector: ImageVector,
    text: String,
    onItemClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}

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