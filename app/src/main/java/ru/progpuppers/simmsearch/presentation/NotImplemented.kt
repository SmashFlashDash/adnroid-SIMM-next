package ru.progpuppers.simmsearch.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun SettingsUi(
    navController: NavController,
    viewModel: SettingsScreenViewModel = hiltViewModel()
) {
    Text(text = "Settings Screen")
}

@Composable
fun DataManageUi(
    navController: NavController,
    viewModel: DataManageScreenViewModel = hiltViewModel()
) {
    Text(text = "Data manage Screen")
}


@HiltViewModel
class SettingsScreenViewModel @Inject constructor() : ViewModel() {

}

@HiltViewModel
class DataManageScreenViewModel @Inject constructor() : ViewModel() {

}