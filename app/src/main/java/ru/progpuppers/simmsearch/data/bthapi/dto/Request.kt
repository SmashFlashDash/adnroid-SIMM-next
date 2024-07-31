package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class Request<T>(
    val cmd: Cmd,
    val params: T? = null
)





