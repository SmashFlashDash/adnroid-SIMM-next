package ru.progpuppers.simmsearch.data.bthapi

import android.bluetooth.BluetoothDevice
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.domain.controller.BluetoothController

// todo: implement logger
class BluetoothControllerTestImpl(private val context: Context): BluetoothController {

    override val scannedDevices: StateFlow<List<BluetoothDevice>>
        get() = MutableStateFlow<List<BluetoothDevice>>(MockData.searchedBluetoothDevices)

    override val pairedDevices: StateFlow<List<BluetoothDevice>>
        get() = MutableStateFlow<List<BluetoothDevice>>(MockData.pairedBluetoothDevices)

    override fun startDiscovery() {
        println("startDiscovery")
    }

    override fun stopDiscovery() {
        println("stopDiscovery")
    }

    override fun release() {
        println("release")
    }

}