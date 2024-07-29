package ru.progpuppers.simmsearch.bthapi

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.progpuppers.simmsearch.data.bthapi.dto.Cmd
import ru.progpuppers.simmsearch.data.bthapi.dto.ParamsCSCB
import ru.progpuppers.simmsearch.data.bthapi.dto.Request


class CustomSerializersTest {

    @Test
    fun int3BitSerializer_serialize_isValid() {
        val testClass = Request(Cmd.RCSS, ParamsCSCB(sims = 3))
        val serialized = Json.encodeToString(testClass)
        //println(serialized)
        assertEquals(serialized, """{"cmd":"RCSS","params":{"sims":3}}""")
    }
}