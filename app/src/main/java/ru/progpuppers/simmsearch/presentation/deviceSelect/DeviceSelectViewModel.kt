package ru.progpuppers.simmsearch.presentation.deviceSelect

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class DeviceSelectViewModel @Inject constructor(
    private val bluetoothController: BluetoothController,
    private val deviceRepository: DeviceRepository,
) : ViewModel() {
    // val savedDevices = deviceRepository.getAllDevices().cachedIn(viewModelScope)

    private val _state = MutableStateFlow(DeviceSelectUiState())
    @SuppressLint("MissingPermission")
    val state = combine(
        bluetoothController.scannedDevices,
        bluetoothController.pairedDevices,
        deviceRepository.savedDevices,
        _state
    ) { scannedDevices, pairedDevices, savedDevices, state ->
        state.copy(
            scannedDevices = scannedDevices,
            pairedDevices = pairedDevices,
            scannedPairedSavedDevices = savedDevices.map { device ->
                DeviceCardItem(
                    _id = device.id,
                    name = device.name,
                    address = device.address,
                    isFound = scannedDevices.any { it.address == device.address },
                    isConnected = pairedDevices.any { it.address == device.address },
                    description = device.description ?: "Нет описания"
                )
            }
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

    // todo: залупить
    fun startScan() = bluetoothController.startDiscovery()

    fun stopScan() = bluetoothController.stopDiscovery()

    fun connectManage(device: DeviceCardItem) {
        if (device.isConnected) bluetoothController.disconnect(device.address)
        else bluetoothController.connect(device.address)
        // println("connectManage: ${device.name} ${device.address}")
        // println("paredDevices: " + state.value.pairedDevices.joinToString(separator = ", ") { it.address })
    }
}

data class DeviceSelectUiState(
    val scannedDevices: List<BthDevice> = emptyList(),
    val pairedDevices: List<BthDevice> = emptyList(),
    val savedDevices: List<BthDevice> = emptyList(),
    val scannedPairedSavedDevices: List<DeviceCardItem> = emptyList()
)

data class DeviceCardItem  (
    val _id: Long = 0L,
    val name: String,
    val address: String,
    val isFound: Boolean = false,
    val isConnected: Boolean = false,
    val description: String = "Нет описания",
) : Serializable