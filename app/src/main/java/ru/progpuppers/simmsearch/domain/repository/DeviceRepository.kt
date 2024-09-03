package ru.progpuppers.simmsearch.domain.repository

import android.bluetooth.BluetoothDevice
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.progpuppers.simmsearch.domain.model.SimmDevice

interface DeviceRepository {

    fun getAllDevices(): Flow<PagingData<SimmDevice>>

    fun getDevices(sources: List<String>): Flow<PagingData<SimmDevice>>

    fun editDevice(device: SimmDevice)

    fun saveDevice(device: SimmDevice)

    suspend fun getAllDevicesMutable(): MutableStateFlow<List<BluetoothDevice>>


    // fun searchDevices(searchQuery: String, sources: List<String>): Flow<PagingData<SimmDevice>>
}