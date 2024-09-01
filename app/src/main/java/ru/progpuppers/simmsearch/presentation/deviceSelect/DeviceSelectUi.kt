package ru.progpuppers.simmsearch.presentation.deviceSelect

import androidx.compose.foundation.layout.Arrangement
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
import androidx.paging.compose.LazyPagingItems
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DeviceCard
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DrawerItemsState
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DrawerSheet
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.TopBar

@Composable
fun DeviceSelectUi(
    devices: LazyPagingItems<SimmDevice>,
    viewModel: DeviceSelectViewModel,
    navigateToDeviceAdd: () -> Unit,
    navigateToDeviceEdit: (SimmDevice) -> Unit,
    navigateToDeviceControl: (SimmDevice) -> Unit = { print("click") },
    navigateToDataMange: () -> Unit = { print("click") },
    navigateToDataExplore: () -> Unit = { print("click") },
    navigateToNavigationMap: () -> Unit = { print("click") },
    navigateToSettings: () -> Unit = { print("click") }
) {
    val uiState = DrawerItemsState.MenuState
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // todo:
    //  - переделать с статик цветов на material.colorScheme
    //  - вариант navController в viewModel чтобы не передавать кучу методов
    //  - пока берется flux devices нжен splash

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerSheet(uiState = uiState) }
    ) {
        Scaffold(
            topBar = {
                TopBar (
                    onAddIconClick = { navigateToDeviceAdd() }
                ) {
                    scope.launch { drawerState.open() }
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(devices.itemCount) {
                    devices[it]?.let { device ->
                        DeviceCard(
                            device = device,
                            onEditClick = { navigateToDeviceEdit(device) },
                            onConnectClick = { print("onConnectClick") },
                            onControlClick = { print("onControlClick") },
                        )
                    }
                }
            }
        }
    }
}
