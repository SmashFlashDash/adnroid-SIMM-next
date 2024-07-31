package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.progpuppers.simmsearch.data.bthapi.utils.ResponseMultiSerializer

@Serializable(ResponseMultiSerializer::class)
sealed class Response {
    abstract val cmd: Cmd?
    abstract val error: Int?
    abstract val desc: String?
    abstract val res: Boolean?

    @Serializable
    data class ResponseCommon(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("error") override val error: Int?,
        @SerialName("desc") override val desc: String?,
        @SerialName("res") override val res: Boolean?,
    ) : Response()

    @Serializable
    data class ResponseRSTA(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("error") override val error: Int?,
        @SerialName("desc") override val desc: String?,
        @SerialName("res") override val res: Boolean?,
        @SerialName("fw") val fw: String?,
        @SerialName("status") val status: String?,
        @SerialName("battery") val battery: Battery?,
        @SerialName("errors") val errors: ErrorsRSTA?,
    ) : Response()

    @Serializable
    data class ResponseRSCA(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("error") override val error: Int?,
        @SerialName("desc") override val desc: String?,
        @SerialName("res") override val res: Boolean?,
        @SerialName("sd") val sd: SD?,
        @SerialName("simcom") val simcom: Simcom?,
        @SerialName("gps") val gps: GpsStatus?,
        @SerialName("accel") val accel: Accelerometer?,
    ) : Response()

    @Serializable
    data class ResponseRSRE(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("error") override val error: Int?,
        @SerialName("desc") override val desc: String?,
        @SerialName("res") override val res: Boolean?,
        val scanId: String?,
        val scanMode: Int?,
        val errors: Int?,
        val time: SearchPeriod?,
        val cycles: CyclesStatus?,
        val gps: GpsData?,
        val ranges: RangesInfo?,
    ) : Response()

    @Serializable
    data class ResponseRSSP(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("error") override val error: Int?,
        @SerialName("desc") override val desc: String?,
        @SerialName("res") override val res: Boolean?,
        @SerialName("log") override val log: Boolean?,
        @SerialName("poweroff") override val powerOff: Int?,
        @SerialName("sims") override val sims: List<Sim>?,
        @SerialName("standalone") override val standalone: Standalone?,
        @SerialName("csop") override val CSOP: CSOP?,
        @SerialName("cycle") override val cycle: Cycle?,
    ) : Response(), СsspTemplate
}



