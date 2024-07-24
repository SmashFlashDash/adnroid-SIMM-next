package ru.progpuppers.bthapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val cmd: Cmd? = null,
    val error: Int? = null,
    val desc: String? = null,
    val res: Boolean? = null
) {
}