package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Battery(
    val error: Boolean?,
    val charging: Boolean?,
    val voltage: Int?,
    val power: Int?,
    val capacity: Int?
)

@Serializable
data class ErrorsRSTA(
    val system: Int?,
    val scan: Int?
)

@Serializable
data class SD(
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
) {
    @Serializable
    data class SimcomBody(
        val simCard: Boolean?,
        val ready: Boolean?,
        val operator: String?,
        val imsi: String?,
        val error: Boolean?,
    )
}


@Serializable
data class GpsStatus(
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
data class SearchPeriod(
    val start: String,  // TODO: to date "2020-03-31T11:43:56"
    val end: String     // TODO: to date
)

@Serializable
data class CyclesStatus(
    val total: Int,
    val current: Int
)

@Serializable
data class GpsData(
    val valid: Boolean,
    val navi: Boolean,
    val pos: String,
    val lat: Double,
    val long: Double,
    val speed: Double,
    val cog: Double,
)

@Serializable
data class RangesInfo(
    @SerialName("2G") val twoG: Cell<Cell2G>,
    @SerialName("3G") val threeG: Cell<Cell3G>
) {
    @Serializable
    data class Cell<T>(
        val errors: Int,
        val ta: Boolean,
        val num: Int,
        val cells: List<T>
    )

    @Serializable
    data class Cell2G(
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
    data class Cell3G(
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
}

