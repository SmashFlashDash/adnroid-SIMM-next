package ru.progpuppers.simmsearch.data.bthapi

import kotlinx.serialization.json.Json

class BthApi (
    private val jsonRequestFactory: Json,
    private val jsonResponseFactory: Json,
) {
    // todo: classic bluettoth
    //  или bluetoothble
    //  сделать так чтобы при переключении в другое приложение продолжал принимать данные


    // todo:
    fun scanDevices() {

    }

    // todo:
    fun connectToDevice() {

    }

}