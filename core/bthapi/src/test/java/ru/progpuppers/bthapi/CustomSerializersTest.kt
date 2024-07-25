package ru.progpuppers.bthapi

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import ru.progpuppers.bthapi.dto.Cmd
import ru.progpuppers.bthapi.dto.Params
import ru.progpuppers.bthapi.dto.Request
import ru.progpuppers.bthapi.utils.Int3BitSerializer

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CustomSerializersTest {
    @Test
    fun int3BitSerializer_serialize_isValid() {
        val testClass = Request(Cmd.RCSS, Params(sims = 3))
        val serialized = Json.encodeToString(testClass)
        //println(serialized)
        assertEquals(serialized, """{"cmd":"RCSS","params":{"sims":3}}""")
    }
}