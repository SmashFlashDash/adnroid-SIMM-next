package ru.progpuppers.simmsearch.presentation.deviceselect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.presentation.DeviceControlScreenViewModel
import ru.progpuppers.simmsearch.presentation.deviceselect.components.DrawerSheet
import ru.progpuppers.simmsearch.presentation.deviceselect.components.LobbyUiState
import ru.progpuppers.simmsearch.presentation.deviceselect.components.TopBar

@Composable
fun DeviceSelectUi(navController: NavController, viewModel: DeviceControlScreenViewModel) {
    val uiState = LobbyUiState.MockedState.lobbyUiMockedState()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerSheet(uiState = uiState) }
    ) {
        Scaffold(
            topBar = { TopBar { scope.launch { drawerState.open() } } }
        ) { paddingValues ->
            val range = 1..2
            Surface(
                modifier = Modifier.padding(paddingValues),
            ) {
                Column {
                    range.forEach { x ->
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "${x}. Lorem ipsum dolor sit amet..."
                        )
                    }
                }

                // LazyColumn(
                //     // modifier = Modifier
                //     //     .fillMaxSize(),
                //     contentPadding = paddingValues,
                //     verticalArrangement = Arrangement.spacedBy(8.dp)
                // ) {
                //     items(range.count()) { index ->
                //         Text(text = "- List item number ${index + 1}")
                //     }
                // }
            }
        }
    }
}
