package ru.progpuppers.simmsearch.presentation.main

sealed class Routes(val route: String) {
    object DeviceSelectUi : Routes("device_select")
    object DeviceAddUi : Routes("device_add")
    object DeviceControlUi : Routes("device_control")
    object DeviceEditUi : Routes("device_manage")
    object SettingsUi : Routes("settings")
    object DataManageUi : Routes("data_manage")
}

// sealed class Route (
//     val route: String
// ) {
//
//     data object MainScreen: Route(route = "mainScreen")
//     data object SettingsScreen: Route(route = "settingsScreen")
//     data object DeviceScreen: Route(route = "deviceScreen")
//     data object DataScreen: Route(route = "dataScreen")
//     data object AppStartNavigation: Route(route = "appStartNavigation")
//
// }