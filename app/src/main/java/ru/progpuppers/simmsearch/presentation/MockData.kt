package ru.progpuppers.simmsearch.presentation

import ru.progpuppers.simmsearch.domain.model.SimmDevice
import java.util.Optional

object MockData {

    val mockSimmDevice = SimmDevice(
        name = "Device name",
        macAddress = Optional.of("whatttidy"),
        isEnable = false,
    )

    val mockSavedDevices
        get() = listOf(
            SimmDevice(name = "Device name 1", macAddress = Optional.of("whatttidy"), isEnable = false),
            SimmDevice(name = "Device name 2 generated auto text", macAddress = Optional.of("whatttidy"), isEnable = false),
            SimmDevice(name = "Device name 3 generated auto text wow wow yeh", macAddress = Optional.of("whatttidy"), isEnable = true)
        )
}