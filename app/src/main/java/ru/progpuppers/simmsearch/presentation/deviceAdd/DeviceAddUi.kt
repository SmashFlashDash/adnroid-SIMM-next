package ru.progpuppers.simmsearch.presentation.deviceAdd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.presentation.common.TopBar
import ru.progpuppers.simmsearch.presentation.deviceAdd.components.DeviceAddCard

@Composable
fun DeviceAddUi(
    viewModel: DeviceAddViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit = { println("click") } // define it here
) {
    // todo: сюда передвавать devices и запускать серчинг bth
    //  сделать карочтоку нового устройства
    // todo: добавить крутилку кода идет поиск устройств
    // todo: LazyList updationg from viewModel
    // todo: здесб тоже показываем card с именами устройства и киким-то инофо, кнопкой добавить

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
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
            items(state.notSavedDevices.count()) { id ->
                state.notSavedDevices[id].let { device ->
                    DeviceAddCard(
                        device = device,
                        onAddClick = { viewModel.saveDevice(device) }
                    )
                }
            }
        }
    }
}