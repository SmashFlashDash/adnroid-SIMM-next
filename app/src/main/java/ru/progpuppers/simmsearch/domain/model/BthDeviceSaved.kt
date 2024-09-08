package ru.progpuppers.simmsearch.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class BthDeviceSaved(
    @PrimaryKey(autoGenerate = true) val id: Long,  // todo: как эт хурма робит
    @ColumnInfo("name") val name: String,
    @ColumnInfo("address") val address: String,
    @ColumnInfo("description") val description: String?
): Serializable {

    // companion object {
    //     fun from(device: BthDevice, description: String? = null): BthDeviceSaved = BthDeviceSaved(
    //         // id = 0L,
    //         // name = device.name ?: "Device ${device.address}",
    //         // address = device.address,
    //         // description = description,
    //
    //         // type = device.type,
    //         // uuids = device.uuids,
    //         // bluetoothClass = device.bluetoothClass,
    //         // bondState = device.bondState,
    //     )
    // }
}