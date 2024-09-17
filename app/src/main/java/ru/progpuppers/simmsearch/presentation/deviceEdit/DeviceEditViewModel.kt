package ru.progpuppers.simmsearch.presentation.deviceEdit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.domain.model.Device
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository


@HiltViewModel(assistedFactory = DeviceEditViewModel.DeviceEditViewModelFactory::class)
class DeviceEditViewModel @AssistedInject constructor(
    @Assisted val device: Device,
    private val deviceRepository: DeviceRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    @AssistedFactory
    interface DeviceEditViewModelFactory {
        fun create(device: Device): DeviceEditViewModel
    }

    var state by mutableStateOf(device)

    // fun initState(deviceCardItem: DeviceCardItem) {
    //     viewModelScope.launch {
    //         deviceRepository.findDeviceById(deviceCardItem._id).collectLatest { device ->
    //             state = state.copy(
    //                 deviceCardItem = deviceCardItem,
    //                 deviceEntity = device
    //             )
    //         }
    //     }
    // }

    fun updateDevice() = viewModelScope.launch { deviceRepository.update(device) }

    fun deleteDevice() = viewModelScope.launch { deviceRepository.delete(device) }

}