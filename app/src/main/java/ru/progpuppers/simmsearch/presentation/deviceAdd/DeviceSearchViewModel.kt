package ru.progpuppers.simmsearch.presentation.deviceAdd

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
import javax.inject.Inject


@HiltViewModel
class DeviceAddViewModel @Inject constructor(
    private val bluetoothController: BluetoothController,
    private val deviceRepository: DeviceRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(DeviceAddState())
    @SuppressLint("MissingPermission")
    val state = combine(
        bluetoothController.scannedDevices,
        deviceRepository.findAllDevices(),
        _state
    ) { scannedDevices, savedDevices, state ->
        state.copy(
            notSavedDevices = scannedDevices.filter { device -> !savedDevices.any { it.address == device.address } }
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

}

data class DeviceAddState(
    val notSavedDevices: List<BthDevice> = emptyList(),
)