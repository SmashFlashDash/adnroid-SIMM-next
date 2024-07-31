package ru.progpuppers.simmsearch.data.bthapi.utils

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import ru.progpuppers.simmsearch.data.bthapi.dto.Cmd
import ru.progpuppers.simmsearch.data.bthapi.dto.Response


object Int3BitSerializer : KSerializer<Int> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(this.javaClass.name, PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): Int {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Int) {
        // TODO: может записать минимум байт
        //  если надо только 3 бит, то пиллить кастомный сериализатор
        // val shiftedval = value shr 2
        encoder.encodeByte(value.toByte())
    }

}

object ResponseMultiSerializer : JsonContentPolymorphicSerializer<Response>(
    Response::class,
) {
    private val otherCmd: Set<String> = setOf(
        Cmd.RCSS.name,
        Cmd.CPOF.name, Cmd.CCST.name, Cmd.CSSC.name, Cmd.CSCB.name, Cmd.CSOP.name, Cmd.CSWM.name,
        Cmd.CSSP.name
    )

    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<Response> {
        val json = element.jsonObject
        val type = json.getValue("cmd").jsonPrimitive.content
        return when (type) {
            Cmd.RSTA.name -> Response.ResponseRSTA.serializer()
            Cmd.RSCA.name -> Response.ResponseRSCA.serializer()
            Cmd.RSRE.name -> Response.ResponseRSRE.serializer()
            Cmd.RSSP.name -> Response.ResponseRSSP.serializer()
            in otherCmd -> Response.ResponseCommon.serializer()
            else -> throw IllegalArgumentException("$type is not a supported Base type.")
        }
    }
}


