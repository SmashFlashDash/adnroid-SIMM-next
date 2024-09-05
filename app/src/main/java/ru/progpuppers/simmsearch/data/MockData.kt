package ru.progpuppers.simmsearch.data

import android.bluetooth.BluetoothDevice
import org.robolectric.shadows.ShadowBluetoothDevice
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

    val searchedBluetoothDevices: List<BluetoothDevice> = listOf(
        ShadowBluetoothDevice.newInstance("00:10:22:33:AA:BB"),
        ShadowBluetoothDevice.newInstance("00:11:22:33:AA:BB"),
        ShadowBluetoothDevice.newInstance("00:12:22:33:AA:BB"),
        ShadowBluetoothDevice.newInstance("00:13:22:33:AA:BB"),
        ShadowBluetoothDevice.newInstance("00:14:22:33:AA:BB"),
        ShadowBluetoothDevice.newInstance("00:15:22:33:AA:BB"),
    )
    // todo: замапить сюда добавить на коннект
    val pairedBluetoothDevices: List<BluetoothDevice> = listOf(
        searchedBluetoothDevices[1],
    )
    val savedBluetoothDevices: List<BluetoothDevice> = listOf(
        searchedBluetoothDevices[0],
        searchedBluetoothDevices[1],
        searchedBluetoothDevices[2],
    )
}