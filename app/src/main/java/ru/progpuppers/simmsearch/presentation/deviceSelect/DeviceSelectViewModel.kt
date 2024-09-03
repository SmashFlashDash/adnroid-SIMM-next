package ru.progpuppers.simmsearch.presentation.deviceSelect

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import javax.inject.Inject

@HiltViewModel
class DeviceSelectViewModel @Inject constructor(
    private val bthService: BthApi,
    // private val deviceUseCases: DeviceUseCases,
    private val bluetoothController: BluetoothController,
    private val deviceRepository: DeviceRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(DeviceSelectUiState())
    val state = convertToUiState()

    // todo:
    //  - первичное открытие запрос на права bth
    //  - при открытии экрана показывает запомненные устройства
    //      устройств хранятся в бд
    //      у них есть id, имя, какие то данные для bth, мб mac-адресс
    //  - начинает сканирование bth показывает устройства к которым можно подключиться
    //  - при нажатии на подключить, и успешном подключении
    //    разблокируется кнопка управлять
    //  - кнопка управлять перебрасываеь на активити управления устройством
    //  - кнопка редактирования устройством перебрасывает на актвити информации об устройстве
    //    позволяет его переименовать, или посмотреть данные о нем

    val savedDevices = deviceRepository.getAllDevices().cachedIn(viewModelScope)
    // val savedDevices = deviceUseCases.getSavedDevices().cachedIn(viewModelScope)
    // val savedDevicesMock = mockSavedDevices

    fun startScan() = bluetoothController.startDiscovery()

    fun stopScan() = bluetoothController.stopDiscovery()

    @SuppressLint("MissingPermission")
    private fun convertToUiState(): StateFlow<DeviceSelectUiState> {
        return combine(
            bluetoothController.scannedDevices,
            bluetoothController.pairedDevices,
            bluetoothController.pairedDevices,
            _state
        ) { scanedDevices, pairedDevices, savedDevices, state ->
            state.copy(
                scannedDevices = scanedDevices,
                pairedDevices = pairedDevices,
                scannedPairedSavedDevices = scanedDevices
                    .filter { savedDevices.contains(it) }
                    .map { device ->
                        SimmDevice(
                            name = device.name,
                            address = device.address.toString(),
                            isEnable = false,
                            isConnected = pairedDevices.contains(device),
                            description = ""
                        )
                    }
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)
    }


}

data class DeviceSelectUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
    val savedDevices: List<BluetoothDevice> = emptyList(),
    val scannedPairedSavedDevices: List<SimmDevice> = emptyList()
)