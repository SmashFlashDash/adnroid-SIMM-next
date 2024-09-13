package ru.progpuppers.simmsearch.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.BthDeviceSaved

interface DeviceRepository {
    val savedDevices: StateFlow<List<BthDeviceSaved>>

    fun getAllDevices(): Flow<PagingData<BthDeviceSaved>>

    fun getDevices(sources: List<String>): Flow<PagingData<BthDeviceSaved>>

    fun editDevice(device: BthDeviceSaved)

    fun saveDevice(device: BthDeviceSaved)

    suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDeviceSaved>>

    suspend fun findDeviceById(id: Long): Flow<BthDeviceSaved>

    suspend fun save(device: BthDevice)


    // fun searchDevices(searchQuery: String, sources: List<String>): Flow<PagingData<SimmDevice>>
}