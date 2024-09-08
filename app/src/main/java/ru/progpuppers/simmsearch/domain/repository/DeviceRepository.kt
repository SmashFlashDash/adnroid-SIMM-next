package ru.progpuppers.simmsearch.domain.repository

import android.bluetooth.BluetoothDevice
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.domain.model.SimmDevice

interface DeviceRepository {
    val savedDevices: StateFlow<List<BthDevice>>

    fun getAllDevices(): Flow<PagingData<SimmDevice>>

    fun getDevices(sources: List<String>): Flow<PagingData<SimmDevice>>

    fun editDevice(device: SimmDevice)

    fun saveDevice(device: SimmDevice)

    suspend fun getAllDevicesMutable(): MutableStateFlow<List<BthDevice>>


    // fun searchDevices(searchQuery: String, sources: List<String>): Flow<PagingData<SimmDevice>>
}