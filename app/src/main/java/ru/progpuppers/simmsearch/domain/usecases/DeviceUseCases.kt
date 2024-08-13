package ru.progpuppers.simmsearch.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

data class DeviceUseCases(
    val getSavedDevices: GetDevices,
    // val searchDevices: SearchDevices
)

class GetDevices(
    private val deviceRepository: DeviceRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<SimmDevice>> {
        return deviceRepository.getDevices(sources = sources)
    }
}