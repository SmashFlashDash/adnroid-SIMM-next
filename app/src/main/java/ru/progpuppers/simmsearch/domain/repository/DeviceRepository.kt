package ru.progpuppers.simmsearch.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.progpuppers.simmsearch.domain.model.Device

interface DeviceRepository {

    fun findAllDevices(): Flow<List<Device>>

    fun findDeviceById(id: Long): Flow<Device>

    suspend fun save(device: Device)

    suspend fun update(device: Device)

    // fun searchDevices(searchQuery: String, sources: List<String>): Flow<PagingData<SimmDevice>>
}