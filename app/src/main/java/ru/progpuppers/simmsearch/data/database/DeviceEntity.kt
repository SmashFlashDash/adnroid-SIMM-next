package ru.progpuppers.simmsearch.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// todo: все companion objects лучше вынести в Mapper
//  и делать не from или of а из обьекта to

@Entity
data class DeviceEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("address") val address: String,
    @ColumnInfo("description") val description: String?
) : Serializable