package ru.progpuppers.simmsearch.data.bthapi.dto

/**
Commands to manage SIMM-searcher activity
 */
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

/**
 * SIMM-searcher responses to invalid commands
 */
enum class Errors(val code: Int, val desc: String) {
    WrongType(1, "Wrong type"),
    WrongCommand(2, "Wrong command"),
    NotImplemented(3, "Not implemented"),
    CriticalDeviceState(4, "Critical device state")
}

interface СsspTemplate {
    val log: Boolean?
    val powerOff: Int?
    val sims: List<Sim>?
    val standalone: Standalone?
    val CSOP: CSOP?
    val cycle: Cycle?
}

