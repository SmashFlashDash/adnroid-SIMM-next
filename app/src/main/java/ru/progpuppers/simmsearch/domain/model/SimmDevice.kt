package ru.progpuppers.simmsearch.domain.model

import java.util.Optional

data class SimmDevice (
    val name: String,
    val macAddress: Optional<String>,
    val isEnable: Boolean,
)