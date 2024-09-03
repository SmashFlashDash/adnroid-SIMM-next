package ru.progpuppers.simmsearch.presentation.deviceAdd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.presentation.common.TopBar
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@Composable
fun DeviceAddUi(
    viewModel: DeviceAddViewModel?,
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit = { println("click") } // define it here
) {
    // todo: сюда передвавать devices и запускать серчинг bth
    //  сделать карочтоку нового устройства
    Scaffold(
        topBar = {
            TopBar(
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        }
    ) { paddingValues ->

        // todo: добавить крутилку кода идет поиск устройств
        // todo: LazyList updationg from viewModel
        // todo: здесб тоже показываем card с именами устройства и киким-то инофо, кнопкой добавить
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // items(devices.itemCount) {
            //     devices[it]?.let { device ->
            //
            //     }
            // }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        DeviceAddUi(null, { }, { })
    }
}