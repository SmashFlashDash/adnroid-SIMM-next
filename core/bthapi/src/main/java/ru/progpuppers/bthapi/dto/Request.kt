package ru.progpuppers.bthapi.dto

import kotlinx.serialization.Serializable

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
    val id: String,
    val sims: String,   // TODO: число
    val mode: String,   // TODO: число

    val cycle:  Cycle,   // TODO: лонги
    val gsm:  Network,   // TODO: лонги
    val egsm:  Network,
    val dcs:  Network,
    val `3g`:  String,  // TODO: name

    val scanMode:  Int,
    val ta:  Boolean,

    val mode2: Int // TODO: режим CSWM конфликтует c этим полем "mode" по имени
) {

}

@Serializable
data class Cycle(
    val type: Int,
    val `val`: Int,  // TODO: name
) {

}

@Serializable
data class Network (
    val st: Int,
    val end: Int
) {

}
