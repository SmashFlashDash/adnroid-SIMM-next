package ru.progpuppers.simmsearch.domain.model

import java.io.Serializable

data class SimmDevice  (
    val name: String,
    val address: String?,   // todo: заменить на String?
    val isEnable: Boolean = false,  // todo: to remove
    val isConnected: Boolean = false,
    val description: String = "Нет описания"
) : Serializable {
}