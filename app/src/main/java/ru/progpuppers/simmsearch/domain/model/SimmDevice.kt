package ru.progpuppers.simmsearch.domain.model

import java.io.Serializable
import java.util.Optional

data class SimmDevice  (
    val name: String,
    val macAddress: Optional<String>,
    val isEnable: Boolean = false,  // todo: to remove
    val description: String = "Нет описания"
) : Serializable {
}