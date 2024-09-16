package ru.progpuppers.simmsearch.domain.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.progpuppers.simmsearch.data.database.DeviceEntity
import ru.progpuppers.simmsearch.domain.model.Device
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

data class DeviceUseCases(
    val getSavedDevices: GetDevices,
    // val searchDevices: SearchDevices
)

class GetDevices(
    private val deviceRepository: DeviceRepository
) {
    // operator fun invoke(): Flow<PagingData<Device>> {
    //     return deviceRepository.findAllDevices()
    // }
}