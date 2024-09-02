package ru.progpuppers.simmsearch.presentation.deviceAdd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceAddUi(
    viewModel: DeviceAddViewModel?,
    onBackClick: () -> Unit = { println("click") }
) {
    // todo: сюда передвавать devices и запускать серчинг bth
    //  сделать карочтоку нового устройства
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(),
                navigationIcon = {
                    InputIcon(
                        onClick = onBackClick,
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        description = "navigation back",
                        tint = Color.Black
                    )
                },
                actions = {
                    InputIcon(
                        onClick = { print("click") },
                        icon = Icons.Filled.MoreVert,
                        description = "extend",
                        tint = Color.Black
                    )
                },
                title = { },
            )
        }
    ) { paddingValues ->

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
        DeviceAddUi(null, { })
    }
}