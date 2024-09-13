package ru.progpuppers.simmsearch.data.database

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

// todo: roomRepositoty for saved devices
class DeviceRepositoryImpl() : DeviceRepository {
    override val savedDevices: StateFlow<List<BthDeviceSaved>>
        get() = TODO("Not yet implemented")


    override fun getAllDevices(): Flow<PagingData<BthDeviceSaved>> {
        TODO("Not yet implemented")
    }

    override fun getDevices(sources: List<String>): Flow<PagingData<BthDeviceSaved>> {
        TODO("Not yet implemented")
    }

    override fun editDevice(device: BthDeviceSaved) {
        TODO("Not yet implemented")
    }

    override fun saveDevice(device: BthDeviceSaved) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDeviceSaved>> {
        TODO("Not yet implemented")
    }

    override suspend fun findDeviceById(id: Long): Flow<BthDeviceSaved> {
        TODO("Not yet implemented")
    }

    override suspend fun save(device: BthDevice) {
        TODO("Not yet implemented")
    }


}