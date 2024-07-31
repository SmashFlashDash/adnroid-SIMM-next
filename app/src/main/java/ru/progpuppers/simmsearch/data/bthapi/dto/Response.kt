package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// todo: передлать на общий класс
//  и наследованные с разными полями, но тогда десериализация по cmd @ClassDiscriminator
@Serializable
data class Response(
    val cmd: Cmd?,
    val error: Int?,
    val desc: String?,
    val res: Boolean?,

    // RSTA
    val fw: String?,
    val status: String?,
    val battery: Battery?,
    val errors: ErrorsSystem?,

    // RSCA
    val sd: Sd?,
    val simcom: Simcom?,
    val gps: Gps?,
    val accel: Accelerometer?,

    // RSRE
    val scanId: String?,
    val scanMode: Int?,
    val errors2: Int?,   // TODO: конфликуте с полем errors RSTA
    val time: SearchPeriod?,
    val cycles: Cycles?,
    val gps2: Gps2?,      // TODO: конфликуте с полем errors RSCA
    val ranges: RangesG?,      // TODO: конфликуте с полем errors RSCA

    // RSSP
    // todo: заекстендить CSSP
)

@Serializable
data class Battery(
    val error: Boolean?,
    val charging: Boolean?,
    val voltage: Int?,
    val power: Int?,
    val capacity: Int?
)

@Serializable
data class ErrorsSystem(
    val system: Int?,
    val scan: Int?
)

@Serializable
data class Sd(
    val isInserted: Boolean?,
    val ready: Boolean?,
    val error: Boolean?,
)

@Serializable
data class Simcom(
    @SerialName("1") val one: SimcomBody,
    @SerialName("2") val two: SimcomBody,
    @SerialName("3") val three: SimcomBody,
    @SerialName("4") val four: SimcomBody
)

@Serializable
data class SimcomBody(
    val simCard: Boolean?,
    val ready: Boolean?,
    val operator: String?,
    val imsi: String?,
    val error: Boolean?,
)

@Serializable
data class Gps(
    val ready: Boolean?,
    val valid: Boolean?,
    val navi: Boolean?,
    val error: Boolean?,
)

@Serializable
data class Accelerometer(
    val ready: Boolean?,
    val error: Boolean?,
)

@Serializable
data class SearchPeriod (
    val start: String,  // TODO: to date "2020-03-31T11:43:56"
    val end: String     // TODO: to date
)

@Serializable
data class Cycles (
    val total: Int,
    val current: Int
)

@Serializable
data class Gps2 (
    val valid: Boolean,
    val navi: Boolean,
    val pos: String,
    val lat: Double,
    val long: Double,
    val speed: Double,
    val cog: Double,
)

@Serializable
data class RangesG (
    @SerialName("2G") val twoG: RangeG<Cell2G>,
    @SerialName("3G") val threeG: RangeG<Cell3G>
)

@Serializable
data class RangeG<T> (
    val errors: Int,
    val ta: Boolean,
    val num: Int,
    val cells: List<T>
)

@Serializable
data class Cell2G (
    val arfcn: Double,
    val mcc: Int,
    val mnc: Int,
    val lac: Int,
    val id: Long,
    val bsic: Int,
    val rxlev: Int,
    val c1: Int,
    val c2: Int,
    val ta: Int,
)

@Serializable
data class Cell3G (
    val type: Int,
    val arfcn: Double,
    val mcc: Int,
    val mnc: Int,
    val lac: Int,
    val id: Long,
    val psc: Int,
    val ssc: Int,
    val rscp: Int,
    val ecio: Double,
    val rxlev: Int,
    val txpwr: Int,
)