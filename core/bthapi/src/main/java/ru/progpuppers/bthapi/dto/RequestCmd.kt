package ru.progpuppers.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.progpuppers.bthapi.utils.Int3BitSerializer

@Serializable
data class ParamsCSCB(
    val id: String? = null,
    @SerialName("sims") @Serializable(with = Int3BitSerializer::class)
    val sims: Int? = null,      // TODO: 4-х битное число. Младший бит справа.  Enum ?
    val mode: Int? = null,      // TODO: 3-х битное число. Младший бит справа.  Enum ?
    val cycle: Cycle? = null,
    val gsm: Range? = null,     // TODO: 1..124МГц
    val egsm: Range? = null,    // TODO: 974..1024Мгц
    val dcs: Range? = null,     // TODO: 512..885МГц
    val `3g`: Int? = null   // TODO: 3-х битное число. Младший бит справа   Enum ?
)

@Serializable
data class ParamsCSOP(
    val id: String? = null,
    @SerialName("sims") @Serializable(with = Int3BitSerializer::class)
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
data class Cycle(
    val type: Int, // TODO: 0,1,2   Enum ?
    val `val`: Int,
    // TODO:  Для предыдущего параметра «1» задаётся в секундах
    //        Для предыдущего параметра «2» задаётся в метрах
    //  - сделать констуктор

)

@Serializable
data class Range(
    val st: Int,
    val end: Int
)

@Serializable
data class Sim(
    val sim: Int,
    val number: String
    // TODO: нужен фолрмат номера, валидировать
    //  может быть null и пустой строкой
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