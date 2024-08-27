package ru.progpuppers.simmsearch.presentation.deviceManage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.progpuppers.simmsearch.domain.model.SimmDevice

@Composable
fun DeviceManageUi(
    navController: NavController,
    viewModel: DeviceManageViewModel,
    device: SimmDevice
) {
    Column (modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        Text("1 Device Manage Ui")
        Text("2 Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
        Text("Device Manage Ui")
    }
}