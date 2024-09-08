package ru.progpuppers.simmsearch.data.database

import android.content.res.Resources.NotFoundException
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

// todo: roomRepositoty for saved devices
class DeviceRepositoryMockImpl() : DeviceRepository {

    override val savedDevices: StateFlow<List<BthDeviceSaved>>
        get() = MutableStateFlow(MockData.savedBthDevices)

    override fun getAllDevices(): Flow<PagingData<BthDeviceSaved>> {
        return flowOf(PagingData.from(MockData.savedBthDevices))
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

    override suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDeviceSaved>> =
        MutableStateFlow(MockData.savedBthDevices)

    // todo: сделать для реального репозитория, он мб и не может вернуть null
    override suspend fun findDeviceById(id: Long): Flow<BthDeviceSaved> =
        flowOf(MockData.savedBthDevices.find { it.id == id } ?:
        throw NotFoundException("device not found by id $id"))
}