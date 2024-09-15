package ru.progpuppers.simmsearch.domain.model

import android.annotation.SuppressLint
import android.bluetooth.BluetoothClass
import android.os.ParcelUuid
import java.io.Serializable

// typealias BluetoothDeviceFound = BthDevice

data class BthDevice(
    val name: String,
    val address: String,
    val type: Int,
    val uuids: List<ParcelUuid>,
    val bluetoothClass: BluetoothClass?,
    val bondState: Int,
) : Serializable {

    companion object {
        @SuppressLint("MissingPermission")
        fun of(device: android.bluetooth.BluetoothDevice): BthDevice = BthDevice(
            name = device.name,
            address = device.address,
            type = device.type,
            uuids = device.uuids.toList(),
            bluetoothClass = device.bluetoothClass,
            bondState = device.bondState
        )
    }

}