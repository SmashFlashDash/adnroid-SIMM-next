package ru.progpuppers.simmsearch.data

import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved

object MockData {

    val searchedBluetoothDevices: List<BthDevice> = listOf(
        BthDevice(name = "New Device 1", address = "00:11:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 2", address = "00:12:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 3", address = "00:13:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 4", address = "00:14:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 5", address = "00:15:22:33:AA:BB", type = 1, uuids = arrayOf(), bluetoothClass = null, bondState = 2),
    )
    // todo: замапить сюда добавить на коннект, сеттеры геттеры
    val pairedBluetoothDevices: List<BthDevice> = listOf(
        searchedBluetoothDevices[0],
    )
    // считаем что address устройства униклаьный и не меняется
    val savedBthDevices: List<BthDeviceSaved> = listOf(
        BthDeviceSaved(id = 1L, name = "Saved Device 1", address = searchedBluetoothDevices[0].address, description = "Нет описания"),
        BthDeviceSaved(id = 2L, name = "Saved Device 2", address = searchedBluetoothDevices[1].address, description = "Есть описания"),
        BthDeviceSaved(id = 3L, name = "Saved Device 3", address = searchedBluetoothDevices[2].address, description = "Есть описания"),
    )

    // val mockSavedDevices
    //     get() = listOf(
    //         DeviceCardItem(name = "Device name 1", address = "whatttidy", isFound = false),
    //         DeviceCardItem(name = "Device name 2 generated auto text", address = "whatttidy", isFound = false),
    //         DeviceCardItem(name = "Device name 3 generated auto text wow wow yeh", address = "whatttidy", isFound = true)
    //     )
    //
    // val mockNewDevices = listOf(
    //     DeviceCardItem(name = "new device 1", address = "whatttidy", isFound = false),
    //     DeviceCardItem(name = "new device 2", address = "whatttidy", isFound = false)
    // )
}