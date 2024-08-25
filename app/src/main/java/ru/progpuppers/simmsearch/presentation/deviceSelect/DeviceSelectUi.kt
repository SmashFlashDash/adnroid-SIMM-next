package ru.progpuppers.simmsearch.presentation.deviceSelect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DeviceCard
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DrawerSheet
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.TopBar
import ru.progpuppers.simmsearch.presentation.deviceSelect.states.DrawerItemsState

@Composable
fun DeviceSelectUi(navController: NavController, viewModel: DeviceSelectViewModel) {
    val uiState = DrawerItemsState.MenuState
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerSheet(uiState = uiState) }
    ) {
        Scaffold(
            topBar = { TopBar { scope.launch { drawerState.open() } } }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // todo: get Flow
                // val devices = viewModel.savedDevices
                val devices = viewModel.savedDevicesMock
                items(devices.size) { index ->
                    DeviceCard(device = devices[index])
                }
            }
        }
    }
}

@Composable
private fun Content(paddingValues: PaddingValues, viewModel: DeviceSelectViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val devices = viewModel.savedDevicesMock
        items(devices.size) { index ->
            DeviceCard(device = devices[index])
        }
    }
}

// @Preview(showBackground = true)
// @Composable
// private fun ContentPreview() {
//     LazyColumn(
//         modifier = Modifier.fillMaxSize(),
//         contentPadding = PaddingValues(10.dp),
//         verticalArrangement = Arrangement.spacedBy(8.dp)
//     ) {
//         items(range.count()) { index ->
//             Text(text = "- List item number ${index + 1}")
//         }
//     }
// }
