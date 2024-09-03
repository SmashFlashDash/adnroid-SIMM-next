package ru.progpuppers.simmsearch.domain.controller

import android.bluetooth.BluetoothDevice
import kotlinx.coroutines.flow.StateFlow

// android.bluetooth.BluetoothDevice
interface BluetoothController {
    val scannedDevices: StateFlow<List<BluetoothDevice>>
    val pairedDevices: StateFlow<List<BluetoothDevice>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()
}