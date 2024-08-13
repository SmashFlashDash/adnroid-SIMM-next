package ru.progpuppers.simmsearch.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.progpuppers.simmsearch.domain.model.SimmDevice

interface DeviceRepository {

    fun getDevices(sources: List<String>): Flow<PagingData<SimmDevice>>

    fun editDevice(device: SimmDevice)

    fun saveDevice(device: SimmDevice)


    // fun searchDevices(searchQuery: String, sources: List<String>): Flow<PagingData<SimmDevice>>
}