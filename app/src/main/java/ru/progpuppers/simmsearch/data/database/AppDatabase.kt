package ru.progpuppers.simmsearch.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DeviceEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: DeviceDao

}