package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.Serializable

@Serializable
open class ResponseSealed(
    val cmd: Cmd?,
    val error: Int?,
    val desc: String?,
    val res: Boolean?
)

