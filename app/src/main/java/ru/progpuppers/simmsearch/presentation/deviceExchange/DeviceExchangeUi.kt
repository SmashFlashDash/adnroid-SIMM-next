package ru.progpuppers.simmsearch.presentation.deviceExchange

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.presentation.deviceMain.DeviceCardItem
import ru.progpuppers.simmsearch.presentation.common.TopBar

@Composable
fun DeviceControlUi(
    viewModel: DeviceExchangeViewModel = hiltViewModel(),
    device: DeviceCardItem,
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit = { println("click") } // define it here
) {
    // todo: cделать appbar + tablayout для отправки комманд
    Scaffold(
        topBar = {
            TopBar(
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        }
    ) { paddingValues ->
        paddingValues.calculateTopPadding()
    }

}