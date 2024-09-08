package ru.progpuppers.simmsearch.presentation.deviceSelect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DeviceCard
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DrawerItemsState
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.DrawerSheet
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.TopBarDrawer

@Composable
fun DeviceSelectUi(
    viewModel: DeviceSelectViewModel,
    // todo:
    // devices: LazyPagingItems<SimmDevice>,
    devices: List<SimmDevice>,
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
    //  - первичное открытие запрос на права bth
    //  - при открытии экрана показывает запомненные устройства
    //      устройств хранятся в бд
    //      у них есть id, имя, какие то данные для bth, мб mac-адресс
    //  - начинает сканирование bth показывает устройства к которым можно подключиться
    //  - при нажатии на подключить, и успешном подключении
    //    разблокируется кнопка управлять
    //  - кнопка управлять перебрасываеь на активити управления устройством
    //  - кнопка редактирования устройством перебрасывает на актвити информации об устройстве
    //    позволяет его переименовать, или посмотреть данные о нем

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(
                modifier = Modifier
                    // .requiredWidth(200.dp)
                    .fillMaxWidth(0.8f),
                uiState = uiState
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopBarDrawer(
                    onAddIconClick = { navigateToDeviceAdd() },
                    onMenuIconClick = { scope.launch { drawerState.open() } }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(devices.count()) { id ->
                    devices[id].let { device ->
                        DeviceCard(
                            device = device,
                            onEditClick = { navigateToDeviceEdit(device) },
                            onConnectClick = { print("onConnectClick") },
                            onControlClick = { navigateToDeviceControl(device) },
                        )
                    }
                }

                // todo:
                // items(devices.itemCount) {
                //     devices[it]?.let { device ->
                //         DeviceCard(
                //             device = device,
                //             onEditClick = { navigateToDeviceEdit(device) },
                //             onConnectClick = { print("onConnectClick") },
                //             onControlClick = { navigateToDeviceControl(device) },
                //         )
                //     }
                // }
            }


        }
    }
}


// todo: всплывающий диалог
// show notImplemented Dialog
// var notAvailablePopupState by rememberSaveable {
//     mutableStateOf(
//         NotAvailablePopUpState.GONE
//     )
// }
// if (notAvailablePopupState.isVisible()) {
//     NotAvailablePopup { notAvailablePopupState = NotAvailablePopUpState.GONE }
// }
// onClick = { notAvailablePopupVisibility = NotAvailablePopUpState.VISIBLE },