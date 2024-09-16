package ru.progpuppers.simmsearch.domain.model

import android.annotation.SuppressLint
import android.bluetooth.BluetoothClass
import android.os.ParcelUuid
import ru.progpuppers.simmsearch.data.database.DeviceEntity
import java.io.Serializable

// typealias BluetoothDeviceFound = BthDevice

data class Device(
    val id: Long? = null,
    val name: String,
    val address: String,
    val description: String?,
) : Serializable

fun DeviceEntity.toDevice():Device  = Device(
    id = id,
    name = name,
    address = address,
    description = description
)

fun Device.toDeviceEntity(): DeviceEntity = DeviceEntity(
    id = id,
    name = name,
    address = address,
    description = description
)