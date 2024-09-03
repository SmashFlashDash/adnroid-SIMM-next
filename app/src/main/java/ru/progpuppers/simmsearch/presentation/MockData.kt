package ru.progpuppers.simmsearch.presentation

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
}