package ru.progpuppers.bthapi.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


object Int3BitSerializer : KSerializer<Int> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(this.javaClass.name, PrimitiveKind.INT)

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

