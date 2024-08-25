package ru.progpuppers.simmsearch.presentation.deviceSelect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.domain.usecases.DeviceUseCases
import ru.progpuppers.simmsearch.presentation.MockData.mockSavedDevices
import javax.inject.Inject

@HiltViewModel
class DeviceSelectViewModel @Inject constructor(
    private val bthService: BthApi,
    private val deviceUseCases: DeviceUseCases
) : ViewModel() {

    // todo:
    //  - первичное открытие запрос на права bth
    //  - при открытии экрана показывает запомненные устройства
    //      устройств хранятся в бд
    //      у них есть id, имя, какие то данные для bth, мб mac-адресс
    //  - начинает сканирование bth показывает устройства к которым можно подключиться
    //  - при нажатии на подключить, и успешном подключении
    //    разблокируется кнопка управлять
    //  - кнопка управлять перебрасываеь на активити управления устройством
    //  - кнопка редактирования устройством перебрасывает на актвити информации об устройстве
    //    позволяет его переименовать, или посмотреть данные о нем

    val savedDevices = deviceUseCases.getSavedDevices(listOf("")).cachedIn(viewModelScope)
    val savedDevicesMock = mockSavedDevices

}