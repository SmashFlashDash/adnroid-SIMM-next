package ru.progpuppers.simmsearch.data.database

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

// todo: roomRepositoty for saved devices
class DeviceRepositoryImpl() : DeviceRepository {
    override val savedDevices: StateFlow<List<BthDevice>>
        get() = TODO("Not yet implemented")


    override fun getAllDevices(): Flow<PagingData<SimmDevice>> {
        TODO("Not yet implemented")
    }

    override fun getDevices(sources: List<String>): Flow<PagingData<SimmDevice>> {
        TODO("Not yet implemented")
    }

    override fun editDevice(device: SimmDevice) {
        TODO("Not yet implemented")
    }

    override fun saveDevice(device: SimmDevice) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDevice>> {
        TODO("Not yet implemented")
    }


}