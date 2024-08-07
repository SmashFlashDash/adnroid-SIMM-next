package ru.progpuppers.simmsearch.presentation.nvgraph

sealed class Route (
    val route: String
) {

    data object MainScreen: Route(route = "mainScreen")
    data object SettingsScreen: Route(route = "settingsScreen")
    data object DeviceScreen: Route(route = "deviceScreen")
    data object DataScreen: Route(route = "dataScreen")
    data object AppStartNavigation: Route(route = "appStartNavigation")

}