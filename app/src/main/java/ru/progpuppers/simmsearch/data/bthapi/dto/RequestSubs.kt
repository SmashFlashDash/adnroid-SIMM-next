package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Cycle(
    val type: Int,
    @SerialName("val") val value: Int,
    // TODO:  Для предыдущего параметра «1» задаётся в секундах
    //        Для предыдущего параметра «2» задаётся в метрах
    //  - сделать констуктор

)

@Serializable
data class Range(
    val st: Int,
    val end: Int
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class Sim(
    val valid: Boolean? = null,    // todo: есть в ответе RSSP
    val sim: Int? = null,          // todo: есть в запросе CSSP, но нет в RSSP
    @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
    // todo: если засеттить параметр все равно десериализует, если так сконфигурен Json
    val number: String? = null,
)

@Serializable
data class Standalone(
    val cscb: CSCB
)

@Serializable
data class CSOP(
    val sims: Int? = null,
    val std: Int? = null,
    val ta: Boolean? = null
)

@Serializable
data class CSCB(
    val sims: Int? = null,  // TODO: 4-х битное число. Младший бит справа.  Enum ?
    val std: Int? = null,   // TODO: что за поле
    val range: Ranges? = null
) {
    @Serializable
    data class Ranges(
        val gsm: Range? = null,
        val egsm: Range? = null,
        val dcs: Range? = null,
        val band3G: Int? = null  // TODO: 3-х битное число. Младший бит справа.  Enum ?
    )
}

