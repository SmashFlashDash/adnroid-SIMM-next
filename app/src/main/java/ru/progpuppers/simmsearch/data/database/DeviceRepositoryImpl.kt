package ru.progpuppers.simmsearch.data.database

import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.progpuppers.simmsearch.domain.model.Device
import ru.progpuppers.simmsearch.domain.model.toDevice
import ru.progpuppers.simmsearch.domain.model.toDeviceEntity
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

class DeviceRepositoryImpl(
    private val dao: DeviceDao
) : DeviceRepository {

    // override val savedDevicesEntity: StateFlow<List<SavedDeviceEntity>>
    //     get() = TODO("Not yet implemented")
    //
    //
    // override fun getAllDevices(): Flow<PagingData<SavedDeviceEntity>> {
    //     TODO("Not yet implemented")
    // }

    override fun findAllDevices(): Flow<List<Device>> =
        dao.findAllDevices().map { it.map { it.toDevice() } }

    override fun findDeviceById(id: Long): Flow<Device> =
        dao.findDeviceById(id).map { it.toDevice() }

    override suspend fun save(device: Device) {
        dao.save(device.toDeviceEntity())
    }

    override suspend fun update(device: Device) {
        dao.save(device.toDeviceEntity())
    }


}