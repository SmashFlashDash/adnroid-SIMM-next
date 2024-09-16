package ru.progpuppers.simmsearch.presentation.deviceAdd

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.data.database.DeviceEntity
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.Device
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

@HiltViewModel(assistedFactory = DeviceSaveViewModel.DeviceSaveViewModelFactory::class)
class DeviceSaveViewModel @AssistedInject constructor(
    @Assisted val device: BthDevice,
    private val deviceRepository: DeviceRepository,
) : ViewModel() {

    @AssistedFactory
    interface DeviceSaveViewModelFactory {
        fun create(device: BthDevice): DeviceSaveViewModel
    }

    val state = mutableStateOf(BthDeviceState(device))

    fun saveDevice() = viewModelScope.launch {
        deviceRepository.save(state.value.toDevice())
    }
}

// todo: мб лишняя вложенность с mutableStateLists
data class BthDeviceState(
    val device: BthDevice,
    val name: MutableState<String> = mutableStateOf(device.name),
    var description: MutableState<String> = mutableStateOf("")
)

fun BthDeviceState.toDevice(): Device = Device(
    name = name.value,
    description = description.value,
    address = device.address
)