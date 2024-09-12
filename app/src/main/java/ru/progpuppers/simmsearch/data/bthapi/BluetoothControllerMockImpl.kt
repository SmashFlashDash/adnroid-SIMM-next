package ru.progpuppers.simmsearch.data.bthapi

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    val _scannedDevices = MutableStateFlow(MockData.searchedBluetoothDevices)
    override val scannedDevices: StateFlow<List<BthDevice>>
        get() = _scannedDevices.asStateFlow()

    val _pairedDevices = MutableStateFlow(MockData.pairedBluetoothDevices)
    override val pairedDevices: StateFlow<List<BthDevice>>
        get() = _pairedDevices.asStateFlow()

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
        _pairedDevices.update { _pairedDevices.value.filter { it.address != address } }
    }

    override fun connect(address: String) {
        _pairedDevices.update {
            _pairedDevices.value + _scannedDevices.value.find { it.address == address }!!
        }
    }

}