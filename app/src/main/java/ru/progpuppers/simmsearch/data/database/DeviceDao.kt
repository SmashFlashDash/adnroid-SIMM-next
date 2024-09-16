package ru.progpuppers.simmsearch.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface DeviceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(device: DeviceEntity): Long

    @Delete
    suspend fun delete(device: DeviceEntity): Int

    @Update
    suspend fun update(device: DeviceEntity): Int

    @Query("SELECT * FROM deviceentity")
    fun findAllDevices(): Flow<List<DeviceEntity>>

    @Query("SELECT * FROM deviceentity WHERE id = :id")
    fun findDeviceById(id: Long): Flow<DeviceEntity>
}