package ru.progpuppers.simmsearch.data.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class Request {
    abstract val cmd: Cmd?

    @Serializable
    data class RequestCSCB(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("params") val params: ParamsCSCB
    ) : Request() {

        @Serializable
        data class ParamsCSCB(
            @SerialName("id") val id: String? = null,
            // @SerialName("sims") @Serializable(with = Int3BitSerializer::class)
            @SerialName("sims") val sims: Int? = null,      // TODO: 4-х битное число. Младший бит справа.
            @SerialName("mode") val mode: Int? = null,      // TODO: 3-х битное число. Младший бит справа.
            @SerialName("cycle") val cycle: Cycle? = null,
            @SerialName("gsm") val gsm: Range? = null,      // TODO: 1..124МГц
            @SerialName("egsm") val egsm: Range? = null,    // TODO: 974..1024Мгц
            @SerialName("dcs") val dcs: Range? = null,      // TODO: 512..885МГц
            @SerialName("3g") val threeG: Int? = null       // TODO: 3-х битное число. Младший бит справа
        )
    }

    @Serializable
    data class RequestCSOP(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("params") val params: ParamsCSOP
    ) : Request() {

        @Serializable
        data class ParamsCSOP(
            @SerialName("id") val id: String? = null,
            @SerialName("sims") val sims: Int? = null,
            @SerialName("mode") val mode: Int? = null,
            @SerialName("scanMode") val scanMode: Int? = null,
            @SerialName("ta") val ta: Boolean? = null,
            @SerialName("cycle") val cycle: Cycle? = null
        )
    }

    @Serializable
    data class RequestCSWM(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("params") val params: ParamsCSWM
    ) : Request() {

        @Serializable
        data class ParamsCSWM(
            @SerialName("mode") val mode: Int? = null,
            // TODO: конфликтует тип c ParamsCSCB
            // mode:
            //0 — SLAVE: Только принимает команды через BLE, кнопки неактивны
            //1 — INDEPENDED: Управляется кнопками на панели прибора
        )
    }

    @Serializable
    data class RequestCSSP(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("params") val params: ParamsCSSP
    ) : Request() {

        @Serializable
        data class ParamsCSSP(
            @SerialName("log") override val log: Boolean? = null,
            @SerialName("poweroff") override val powerOff: Int? = null,
            @SerialName("sims") override val sims: List<Sim>? = null,
            @SerialName("standalone") override val standalone: Standalone? = null,
            @SerialName("csop") override val CSOP: CSOP? = null,
            @SerialName("cycle") override val cycle: Cycle? = null
        ) : СsspTemplate
    }

    @Serializable
    data class RequestRSRE(
        @SerialName("cmd") override val cmd: Cmd?,
        @SerialName("params") val params: ParamsRSRE
    ) : Request() {

        @Serializable
        data class ParamsRSRE(
            @SerialName("scanId") val scanId: String? = null,
            @SerialName("cycle") val cycle: Int? = null
        )

    }

}





