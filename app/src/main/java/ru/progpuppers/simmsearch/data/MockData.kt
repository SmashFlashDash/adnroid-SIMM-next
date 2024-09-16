package ru.progpuppers.simmsearch.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.data.database.DeviceEntity
import ru.progpuppers.simmsearch.data.database.DeviceRepositoryImpl
import ru.progpuppers.simmsearch.domain.model.toDevice

object MockData {

    val searchedBluetoothDevices: List<BthDevice> = listOf(
        BthDevice(name = "New Device 1", address = "00:11:22:33:AA:BB", type = 1, uuids = emptyList(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 2", address = "00:12:22:33:AA:BB", type = 1, uuids = emptyList(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 3", address = "00:13:22:33:AA:BB", type = 1, uuids = emptyList(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 4", address = "00:14:22:33:AA:BB", type = 1, uuids = emptyList(), bluetoothClass = null, bondState = 2),
        BthDevice(name = "New Device 5", address = "00:15:22:33:AA:BB", type = 1, uuids = emptyList(), bluetoothClass = null, bondState = 2),
    )
    val pairedBluetoothDevices: List<BthDevice> = listOf(
        searchedBluetoothDevices[0],
    )
    // считаем что address устройства униклаьный и не меняется
    val savedBthDevices: List<DeviceEntity> = listOf(
        DeviceEntity(id = 1L, name = "Saved Device 1", address = searchedBluetoothDevices[0].address, description = "Нет описания"),
        DeviceEntity(id = 2L, name = "Saved Device 2", address = searchedBluetoothDevices[1].address, description = "Есть описания"),
        DeviceEntity(id = 3L, name = "Saved Device 3", address = searchedBluetoothDevices[2].address, description = "Есть описания"),
    )

    fun initToDeviceRepository(repository: DeviceRepositoryImpl) {
        // val myCoroutineScope = CoroutineScope(Dispatchers.Main)
        runBlocking {
            // val savedDevices = repository.findAllDevices().stateIn(myCoroutineScope).value
            val savedDevices = repository.findAllDevices().first()
            if (savedDevices.isEmpty()) {
                repository.save(savedBthDevices[0].toDevice())
                repository.save(savedBthDevices[1].toDevice())
                repository.save(savedBthDevices[2].toDevice())
            }
        }
    }

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