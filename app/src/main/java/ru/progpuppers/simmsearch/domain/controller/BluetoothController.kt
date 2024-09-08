package ru.progpuppers.simmsearch.domain.controller

import android.bluetooth.BluetoothDevice
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.domain.model.BthDevice

interface BluetoothController {
    val scannedDevices: StateFlow<List<BthDevice>>
    val pairedDevices: StateFlow<List<BthDevice>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()
}