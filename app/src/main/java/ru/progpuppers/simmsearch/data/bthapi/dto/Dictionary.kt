package ru.progpuppers.simmsearch.data.bthapi.dto

// todo: сделать:
//  - общий класс для респонс ответ
//  - кастомный серилазиатор в json, доавлять \r\n после json
//    не сериализовать null поля
//  - кастомный десериализатор json, откидывать с конца \r\n\r\n
//  - логировать все респонсы и реквесты raw в urf8

// Commands to manage SIMM-searcher activity
enum class Cmd {
    RSTA,   // get is device ready to get commands
    RCSS,   // get status current search
    RSCA,   // get status is ready to search
    RSRE,   // get search results
    RSSP,   // get device system params

    CPOF,   // turn off
    CCST,   // stop looped search
    CSSC,   // repeat search sim-cards
    CSCB,   // search in range
    CSOP,   // search operators
    CSWM,   // set working mode
    CSSP,   // set device parameters
}

// SIMM-searcher responses to invalid commands
enum class Errors(val code: Int, val desc: String) {
    WrongType(1, "Wrong type"),
    WrongCommand(1, "Wrong command"),
    NotImplemented(3, "Not implemented"),
    CriticalDeviceState(4, "Critical device state")
}

