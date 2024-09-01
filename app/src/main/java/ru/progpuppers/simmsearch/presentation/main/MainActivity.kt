package ru.progpuppers.simmsearch.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.presentation.DataManageUi
import ru.progpuppers.simmsearch.presentation.DeviceControlUi
import ru.progpuppers.simmsearch.presentation.SettingsUi
import ru.progpuppers.simmsearch.presentation.deviceAdd.DeviceAddUi
import ru.progpuppers.simmsearch.presentation.deviceEdit.DeviceEditUi
import ru.progpuppers.simmsearch.presentation.deviceSelect.DeviceSelectUi
import ru.progpuppers.simmsearch.presentation.deviceSelect.DeviceSelectViewModel
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        enableEdgeToEdge()
        // todo: заимплементить тему
        //  https://developer.android.com/develop/ui/views/theming/darktheme
        //  https://stackoverflow.com/questions/69186894/trigger-dark-mode-of-system-from-application-programmatically-in-android-studio
        //  https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94

        // todo: эт нафига
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        setContent {
            SimmnextTheme {
                SetBarColor(!isSystemInDarkTheme())
                // Surface(
                //     // todo: Surface нужен чтобы определить разметки на все слудющие активити в нем
                //     modifier = Modifier.fillMaxSize(),
                //     color = MaterialTheme.colorScheme.background
                // ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.DeviceSelectUi.route
                    ) {
                        composable(Routes.DeviceSelectUi.route) {
                            val viewModel: DeviceSelectViewModel = hiltViewModel()
                            val devices = viewModel.savedDevices.collectAsLazyPagingItems()
                            // todo: доделать кард device
                            //  - псоле активи и логики addDebvice
                            //  - добавить логику подключения
                            DeviceSelectUi(
                                devices = devices,
                                viewModel = viewModel,
                                navigateToDeviceEdit = { device -> navigateToDeviceEdit(navController = navController, device = device) },
                                navigateToDeviceAdd = { navigateToDeviceAdd(navController = navController) }
                            )
                        }
                // todo:
                //  - лучший вариант для навигации
                //  - сделать для дргуих экранов AppBar с навигацией назазд, доп функции

                        // todo: сделать активити
                        composable(Routes.DeviceAddUi.route) {
                            DeviceAddUi(navController, hiltViewModel())
                        }
                        // todo: сделать активити
                        composable(Routes.DeviceEditUi.route) {
                            navController.previousBackStackEntry?.savedStateHandle?.get<SimmDevice?>("device")
                                ?.let { device -> DeviceEditUi(navController, hiltViewModel(), device) }
                        }
                        composable(Routes.DeviceControlUi.route) {
                            // todo: передать инфо об устройстве
                            DeviceControlUi(navController, hiltViewModel())
                        }
                        composable(Routes.DataManageUi.route) {
                            DataManageUi(navController, hiltViewModel())
                        }
                        composable(Routes.SettingsUi.route) {
                            SettingsUi(navController, hiltViewModel())
                        }
                    }
                // }
            }
        }
    }

    @Composable
    private fun SetBarColor(isLightTheme: Boolean) {
        val barColor = MaterialTheme.colorScheme.background.toArgb()
        // val barColor = Color.Red.toArgb()
        LaunchedEffect(true) {
            if (isLightTheme) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(barColor, barColor),
                    navigationBarStyle = SystemBarStyle.light(barColor, barColor),
                )
            } else {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(barColor),
                    navigationBarStyle = SystemBarStyle.dark(barColor),
                )
            }
        }
    }
}

private fun navigateToDeviceEdit(navController: NavController, device: SimmDevice) {
    navController.currentBackStackEntry?.savedStateHandle?.set("device", device)
    navController.navigate(route = Routes.DeviceEditUi.route)
}

private fun navigateToDeviceAdd(navController: NavController) {
    navController.navigate(route = Routes.DeviceAddUi.route)
}
