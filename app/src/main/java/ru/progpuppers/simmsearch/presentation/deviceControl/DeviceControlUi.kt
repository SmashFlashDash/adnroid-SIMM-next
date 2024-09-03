package ru.progpuppers.simmsearch.presentation.deviceControl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.presentation.common.TopBar

@Composable
fun DeviceControlUi(
    viewModel: DeviceControlViewModel,
    device: SimmDevice,
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