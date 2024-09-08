package ru.progpuppers.simmsearch.data

import android.os.ParcelUuid
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.SimmDevice

object MockData {

    val mockSimmDevice = SimmDevice(
        name = "Device name",
        address = "whatttidy",
        description = "Описание устройства",
    )

    val mockSavedDevices
        get() = listOf(
            SimmDevice(name = "Device name 1", address = "whatttidy", isEnable = false),
            SimmDevice(name = "Device name 2 generated auto text", address = "whatttidy", isEnable = false),
            SimmDevice(name = "Device name 3 generated auto text wow wow yeh", address = "whatttidy", isEnable = true)
        )

    val mockNewDevices = listOf(
        SimmDevice(name = "new device 1", address = "whatttidy", isEnable = false),
        SimmDevice(name = "new device 2", address = "whatttidy", isEnable = false)
    )

    val searchedBluetoothDevices: List<BthDevice> = listOf(
        BthDevice(name = "Device 0", address = "00:10:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "Device 1", address = "00:11:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "Device 2", address = "00:12:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "Device 3", address = "00:13:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "Device 4", address = "00:14:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "Device 5", address = "00:15:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
    )
    // todo: замапить сюда добавить на коннект, сеттеры геттеры
    val pairedBluetoothDevices: List<BthDevice> = listOf(
        searchedBluetoothDevices[1],
    )
    val savedBluetoothDevices: List<BthDevice> = listOf(
        searchedBluetoothDevices[0],
        searchedBluetoothDevices[1],
        searchedBluetoothDevices[2],
    )
}