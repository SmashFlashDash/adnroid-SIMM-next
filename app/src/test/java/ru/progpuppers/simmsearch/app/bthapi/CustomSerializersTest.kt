package ru.progpuppers.simmsearch.bthapi

import kotlinx.serialization.encodeToString
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.progpuppers.simmsearch.data.bthapi.dto.Cmd
import ru.progpuppers.simmsearch.data.bthapi.dto.Request
import ru.progpuppers.simmsearch.data.bthapi.dto.Response
import ru.progpuppers.simmsearch.data.bthapi.dto.Sim
import ru.progpuppers.simmsearch.data.bthapi.utils.ResponseMultiSerializer
import ru.progpuppers.simmsearch.di.AppModule


class CustomSerializersTest {
    val jsonRequestFactory = AppModule.jsonRequestFactory()
    val jsonResponseFactory = AppModule.jsonResponseFactory()

    @Test
    fun int3BitSerializer_serialize_isValid() {
        val testClass = Request.RequestCSCB(Cmd.RCSS, Request.RequestCSCB.ParamsCSCB(sims = 3))
        val serialized = jsonRequestFactory.encodeToString(testClass)
        println(serialized)
        assertEquals(
            """{"cmd":"RCSS","params":{"sims":3}}""",
            serialized
        )
    }

    @Test
    fun nullNumberField_serialize_isValid() {
        val testClass = Request.RequestCSSP(
            Cmd.CSSP, Request.RequestCSSP.ParamsCSSP(
                false,
                0,
                listOf(Sim(true, 0, "+7-800-800-00-00"), Sim(number = null)),
                null,
                null,
                null,
            )
        )
        val serialized = jsonRequestFactory.encodeToString(testClass)
        println(serialized)
        assertEquals(
            """{"cmd":"CSSP","params":{"log":false,"poweroff":0,"sims":[{"valid":true,"sim":0,"number":"+7-800-800-00-00"},{"number":null}]}}""".trimIndent(),
            serialized
        )
    }

    @Test
    fun multiClassesResponse_deserialize_isValid() {
        val jsonText = """{"cmd":"RSSP","error":0,"desc":null,"res":false}""".trimIndent()
        val response = jsonResponseFactory.decodeFromString(ResponseMultiSerializer, jsonText)
        println(response.javaClass.name)
        println(response)
        assertTrue("Wrong class cast in Serializer", response is Response.ResponseRSSP)
    }
}