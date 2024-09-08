package ru.progpuppers.simmsearch.domain.model

import android.annotation.SuppressLint
import android.bluetooth.BluetoothClass
import android.os.ParcelUuid

typealias BluetoothDeviceFound = BthDevice

data class BthDevice(
    val name: String?,
    val address: String,
    val type: Int,
    val uuids: Array<ParcelUuid>,
    val bluetoothClass: BluetoothClass?,
    val bondState: Int
) {
    companion object {
        @SuppressLint("MissingPermission")
        fun from(device: android.bluetooth.BluetoothDevice): BthDevice = BthDevice(
            name = device.name,
            address = device.address,
            type = device.type,
            uuids = device.uuids,
            bluetoothClass = device.bluetoothClass,
            bondState = device.bondState,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BthDevice
        if (name != other.name) return false
        if (address != other.address) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + address.hashCode()
        return result
    }

}