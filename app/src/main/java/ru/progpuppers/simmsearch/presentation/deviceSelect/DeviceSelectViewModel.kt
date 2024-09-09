package ru.progpuppers.simmsearch.presentation.deviceSelect

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class DeviceSelectViewModel @Inject constructor(
    // private val deviceUseCases: DeviceUseCases,
    private val bluetoothController: BluetoothController,
    private val deviceRepository: DeviceRepository,
) : ViewModel() {
    // val savedDevices = deviceRepository.getAllDevices().cachedIn(viewModelScope)

    private val _state = MutableStateFlow(DeviceSelectUiState())
    val state = convertToUiState()

    // todo: залупить
    fun startScan() = bluetoothController.startDiscovery()

    fun stopScan() = bluetoothController.stopDiscovery()

    @SuppressLint("MissingPermission")
    private fun convertToUiState(): StateFlow<DeviceSelectUiState> {
        return combine(
            bluetoothController.scannedDevices,
            bluetoothController.pairedDevices,
            deviceRepository.savedDevices,
            _state
        ) { scannedDevices, pairedDevices, savedDevices, state ->
            state.copy(
                scannedDevices = scannedDevices,
                pairedDevices = pairedDevices,
                scannedPairedSavedDevices = savedDevices
                    // todo: показываем только сохраненные devices
                    // у них полюбому должен быть name который рандомно проставляется в addDeviceUi
                    // - BthDevice объект любых блютуз устройства
                    // - BthDeviceSaved - entity для room, сохраненные устройства
                    // - DeviceCardItem - для использования в deviceSelectUi

                    // todo: по какому полю здесь contains
                    // .filter { savedDevices.contains(it) }
                    .map { device ->
                        DeviceCardItem(
                            _id = device.id,
                            name = device.name,
                            address = device.address,
                            // todo: можно сделать equals и hashCode чтобы использовать containts
                            // isFound = scannedDevices.contains(device),
                            isFound = scannedDevices.any{it.address == device.address},
                            isConnected = pairedDevices.any{it.address == device.address},
                            description =  device.description ?: "Нет описания"
                        )
                    }
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)
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
) : Serializable {
}