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
import ru.progpuppers.simmsearch.presentation.deviceSelect.components.TopBarDrawer

data class DeviceSelectState(
    // val scannedDevices: List<BluetoothDevice> = emptyList(),
    // val pairedDevices: List<BluetoothDevice> = emptyList(),

    // todo:
    //  - список устройств доступых по близости -> если загрузился убираем splash
    //  - подключен ли SimmDevice в сard -> доступна кнопка управление в определенный card
    //
    val boolean: Boolean
)
