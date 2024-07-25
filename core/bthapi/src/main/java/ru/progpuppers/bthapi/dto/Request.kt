package ru.progpuppers.bthapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.progpuppers.bthapi.utils.Int3BitSerializer

// TODO:
//  - по дефолту в java BigEndian то что над
//  -----
//  т.к. в некоторых полях ожидается 3 бит число, 4 бит число
//  прийдется прикручивать си типы или битовые маски
//  ---
//  как вариант прикрутить в класс toByte метод, который по своей логике
//  будет фигчить байтами
//  но надо соблюдать структуру json, но ведь это уже не json
//  мб есть в kotlinx.serializer сериализация для выбранных полей
//  ----
//  вроде не проблема иметь общий реквест класс
//  null поля сделать не сериализемыми
//  но мб kotlinx.serializer плохо робит с дефолтными
//  ----
//  для конфликтующих полей мб сделать второй вложенных класс
//  или сделать Request дженериком
//  и расширять второй класс дефайнить какая структура Param

@Serializable
data class Request(
    val cmd: Cmd,
    val params: Params? = null

) {
}

@Serializable
data class Params(
    val id: String? = null,
    @SerialName("sims") @Serializable(with = Int3BitSerializer::class) val sims: Int? = null,   // TODO: сериализатор
    val mode: Int? = null,   // TODO: сериализатор

    val cycle: Cycle? = null,   // TODO: лонги
    val gsm: Network? = null,   // TODO: лонги
    val egsm: Network? = null,
    val dcs: Network? = null,
    val `3g`: String? = null,  // TODO: name

    val scanMode: Int? = null,
    val ta: Boolean? = null,

    val mode2: Int? = null // TODO: режим CSWM конфликтует c этим полем "mode" по имени
) {

}

@Serializable
data class Cycle(
    val type: Int,
    val `val`: Int,  // TODO: name
) {

}

@Serializable
data class Network(
    val st: Int,
    val end: Int
) {

}
