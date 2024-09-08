package ru.progpuppers.simmsearch.presentation.deviceEdit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import ru.progpuppers.simmsearch.presentation.deviceSelect.DeviceCardItem
import javax.inject.Inject

@HiltViewModel
class DeviceEditViewModel @Inject constructor(
    val deviceRepository: DeviceRepository
) : ViewModel() {

    var state by mutableStateOf(DeviceEditUiState())

    init {
        // savedStateHandle.get<DeviceCardItem>("device")?.let {
        //     viewModelScope.launch {
        //         deviceRepository.findDeviceById(it._id).collectLatest { device ->
        //             state = state.copy(
        //                 deviceCardItem = it,
        //                 savedDevice = device
        //             )
        //         }
        //     }
        // }
    }

}

data class DeviceEditUiState(
    val deviceCardItem: DeviceCardItem? = null,
    val savedDevice: BthDeviceSaved? = null
)