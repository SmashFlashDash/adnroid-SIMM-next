package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.progpuppers.simmsearch.data.bthapi.utils.Int3BitSerializer

@Serializable
data class ParamsCSCB(
    val id: String? = null,
    // @SerialName("sims") @Serializable(with = Int3BitSerializer::class)
    val sims: Int? = null,      // TODO: 4-х битное число. Младший бит справа.
    val mode: Int? = null,      // TODO: 3-х битное число. Младший бит справа.
    val cycle: Cycle? = null,
    val gsm: Range? = null,     // TODO: 1..124МГц
    val egsm: Range? = null,    // TODO: 974..1024Мгц
    val dcs: Range? = null,     // TODO: 512..885МГц
    @SerialName("3g") val threeG: Int? = null   // TODO: 3-х битное число. Младший бит справа
)

@Serializable
data class ParamsCSOP(
    val id: String? = null,
    val sims: Int? = null,
    val mode: Int? = null,
    val scanMode: Int? = null,
    val ta: Boolean? = null,
    val cycle: Cycle? = null
)

@Serializable
data class ParamsCSWM(
    val mode: Int? = null,
    // TODO: конфликтует тип c ParamsCSCB
    // mode:
    //0 — SLAVE: Только принимает команды через BLE, кнопки неактивны
    //1 — INDEPENDED: Управляется кнопками на панели прибора
    // TODO: Enumm ?
)

@Serializable
data class ParamsCSSP(
    val log: Boolean? = null,
    val poweroff: Int? = null,
    val sims: List<Sim>? = null,
    val standalone: Standalone? = null,
    val csop: CSOP? = null,
    val cycle: Cycle? = null
)

@Serializable
data class ParamsRSRE(
    val scanId: String? = null,
    val cycle: Int? = null
)

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
data class Sim (
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
)

@Serializable
data class Ranges(
    val gsm: Range? = null,
    val egsm: Range? = null,
    val dcs: Range? = null,
    val band3G: Int? = null  // TODO: 3-х битное число. Младший бит справа.  Enum ?
)