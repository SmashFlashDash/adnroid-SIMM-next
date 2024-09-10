package ru.progpuppers.simmsearch.data.bthapi

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.model.BthDevice

// todo: implement logger
class BluetoothControllerMockImpl(
    private val context: Context,
    private val jsonRequestFactory: Json,
    private val jsonResponseFactory: Json
) : BluetoothController {

    override val scannedDevices: StateFlow<List<BthDevice>>
        get() = MutableStateFlow(MockData.searchedBluetoothDevices)

    override val pairedDevices: StateFlow<List<BthDevice>>
        get() = MutableStateFlow(MockData.pairedBluetoothDevices)

    override fun startDiscovery() {
        println("startDiscovery")
    }

    override fun stopDiscovery() {
        println("stopDiscovery")
    }

    override fun release() {
        println("release")
    }

    override fun disconnect(address: String) {
        MockData.pairedBluetoothDevices.removeIf { it.address == address }
    }

    override fun connect(address: String) {
        MockData.pairedBluetoothDevices.add(MockData.searchedBluetoothDevices.find { it.address == address }!!)
    }

}