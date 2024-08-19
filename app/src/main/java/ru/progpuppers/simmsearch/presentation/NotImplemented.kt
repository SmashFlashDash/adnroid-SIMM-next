package ru.progpuppers.simmsearch.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun SettingsUi(navController: NavController, viewModel: SettingsScreenViewModel) {
    Text(text = "Settings Screen")
}

@Composable
fun DataManageUi(navController: NavController, viewModel: DataManageScreenViewModel) {
    Text(text = "Data manage Screen")
}

@Composable
fun DeviceControlUi(navController: NavController, viewModel: DeviceControlScreenViewModel) {
    Text(text = "Device Control Screen")
}

@HiltViewModel
class SettingsScreenViewModel @Inject constructor() : ViewModel() {

}

@HiltViewModel
class DataManageScreenViewModel @Inject constructor() : ViewModel() {

}
@HiltViewModel
class DeviceControlScreenViewModel @Inject constructor() : ViewModel() {

}