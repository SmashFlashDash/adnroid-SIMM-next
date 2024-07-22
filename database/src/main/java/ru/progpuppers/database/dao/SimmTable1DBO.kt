package ru.progpuppers.database.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SimmTable1DBO (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo("data") val data: String
)