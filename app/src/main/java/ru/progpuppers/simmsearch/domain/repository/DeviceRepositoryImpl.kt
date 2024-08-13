package ru.progpuppers.simmsearch.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import java.util.Optional

class DeviceRepositoryImpl(
    private val bthApi: BthApi
    // todo: roomRepositoty
): DeviceRepository {

    override fun getDevices(sources: List<String>): Flow<PagingData<SimmDevice>> {
        return flowOf(PagingData.from(listOf(
            SimmDevice("device1", Optional.empty(), false),
            SimmDevice("device2", Optional.of("mock"), true)
        )))
        TODO("Not yet implemented")
    }

    override fun editDevice(device: SimmDevice) {
        TODO("Not yet implemented")
    }

    override fun saveDevice(device: SimmDevice) {
        TODO("Not yet implemented")
    }


}