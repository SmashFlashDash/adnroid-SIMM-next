package ru.progpuppers.simmsearch.data.database

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.data.MockData.mockSavedDevices
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

// todo: roomRepositoty for saved devices
class DeviceRepositoryMockImpl() : DeviceRepository {

    override val savedDevices: StateFlow<List<BthDevice>>
        get() = MutableStateFlow(MockData.savedBluetoothDevices)

    override fun getAllDevices(): Flow<PagingData<SimmDevice>> {
        return flowOf(PagingData.from(mockSavedDevices))
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

    override suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDevice>> =
        MutableStateFlow(MockData.savedBluetoothDevices)

}