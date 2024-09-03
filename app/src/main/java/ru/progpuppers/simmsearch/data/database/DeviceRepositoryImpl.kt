package ru.progpuppers.simmsearch.data.database

import android.bluetooth.BluetoothDevice
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import ru.progpuppers.simmsearch.presentation.MockData.mockSavedDevices
import java.util.Optional

// todo: roomRepositoty for saved devices
class DeviceRepositoryImpl(): DeviceRepository {
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

    override suspend fun getAllDevicesMutable(): MutableStateFlow<List<BluetoothDevice>> {
        TODO("Not yet implemented")
    }


}