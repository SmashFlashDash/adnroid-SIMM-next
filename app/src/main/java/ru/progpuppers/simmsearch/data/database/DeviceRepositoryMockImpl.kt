package ru.progpuppers.simmsearch.data.database

import android.content.res.Resources.NotFoundException
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository

// todo: roomRepositoty for saved devices
class DeviceRepositoryMockImpl() {

    // val _savedDevices = MutableStateFlow(MockData.savedBthDevices)
    // override val savedDevicesEntity: StateFlow<List<SavedDeviceEntity>>
    //     get() = _savedDevices.asStateFlow()
    //
    //
    // override fun getAllDevices(): Flow<PagingData<SavedDeviceEntity>> {    //     // return flowOf(PagingData.from(MockData.savedBthDevices))
    //     TODO("Not yet implemented")
    // }
    //
    // override fun getDevices(sources: List<String>): Flow<PagingData<SavedDeviceEntity>> {
    //     TODO("Not yet implemented")
    // }
    //
    // override fun editDevice(device: SavedDeviceEntity) {
    //     TODO("Not yet implemented")
    // }
    //
    // override fun saveDevice(device: SavedDeviceEntity) {
    //     TODO("Not yet implemented")
    // }
    //
    // override suspend fun getAllDevicesMutable(): MutableStateFlow<List<SavedDeviceEntity>> {
    //     TODO("Not yet implemented")
    // }
    //
    // // todo: сделать для реального репозитория, он мб и не может вернуть null
    // override suspend fun findDeviceById(id: Long): Flow<SavedDeviceEntity> =
    //     flowOf(MockData.savedBthDevices.find { it.id == id } ?: throw NotFoundException("device not found by id $id"))
    //
    // override suspend fun save(device: SavedDeviceEntity) {
    //     _savedDevices.update { _savedDevices.value + device }
    // }
}