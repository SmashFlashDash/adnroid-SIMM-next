package ru.progpuppers.simmsearch.presentation.deviceEdit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved
import ru.progpuppers.simmsearch.presentation.deviceSelect.DeviceCardItem
import ru.progpuppers.simmsearch.presentation.common.TopBar

@Composable
fun DeviceEditUi(
    viewModel: DeviceEditViewModel = hiltViewModel(),
    device: DeviceCardItem,
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit = { println("click") } // define it here
) {
    // todo: сюда закидывается simmDevice
    //  - есть поля редактируемые и не редактируемые
    //  - при редктировании поля, изменения должны отправитьбся в репозиторий
    //
    //  - по сути для это страницы нужно подгрузить сущность из repository по

    Scaffold(
        topBar = {
            TopBar(
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        },
        // bottomBar = {
        //     BottomAppBar() {
        //         // CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        //         //     IconButton(onClick = { /* doSomething() */ }) {
        //         //         Icon(Icons.Filled.Menu, contentDescription = "Localized description")
        //         //     }
        //         // }
        //         // Spacer(Modifier.weight(1f, true))
        //         IconButton(onClick = { /* doSomething() */ }) {
        //             Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        //         }
        //         IconButton(onClick = { /* doSomething() */ }) {
        //             Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        //         }
        //     }
        // }
    ) { paddingValues ->

        // todo:
        //  - cначала уточнтть какие свойства есть при подключении к блюту
        //  - в viewModel кинуть действия с репозиторием
        //  - делать изменения полей device в бд
        //  - нужен ui свойств

        Column(
            modifier = Modifier
                .fillMaxSize()
                // .padding(bottom = paddingValues.calculateBottomPadding())
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Bottom app bar padding:  $paddingValues")
            repeat(50) {
                Text(viewModel.state.deviceCardItem?.name ?: "Device not found")
            }
        }
    }
}