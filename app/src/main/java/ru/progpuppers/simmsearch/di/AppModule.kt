package ru.progpuppers.simmsearch.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.app.BuildConfig
import ru.progpuppers.simmsearch.data.bthapi.BluetoothControllerImpl
import ru.progpuppers.simmsearch.data.bthapi.BluetoothControllerTestImpl
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.data.database.DeviceRepositoryImpl
import ru.progpuppers.simmsearch.data.database.DeviceRepositoryMockImpl
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import ru.progpuppers.simmsearch.domain.usecases.DeviceUseCases
import ru.progpuppers.simmsearch.domain.usecases.GetDevices
import javax.inject.Singleton
import kotlin.math.log

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val jsonRequestFactory = Json { encodeDefaults = false }
    val jsonResponseFactory = Json {
        encodeDefaults = false
        explicitNulls = false
        classDiscriminator = "cmd"
    }

    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController {
        return if (BuildConfig.BUILD_TYPE == "release") BluetoothControllerImpl(context)
        else BluetoothControllerTestImpl(context)
    }

    @Singleton
    @Provides
    fun bthApi(): BthApi = BthApi(jsonRequestFactory, jsonResponseFactory)

    @Singleton
    @Provides
    fun deviceRepository(): DeviceRepository {
        return if (BuildConfig.BUILD_TYPE == "release") DeviceRepositoryImpl()
        else DeviceRepositoryMockImpl()
    }

    // todo: нафиг нужен лишний уровень
    @Singleton
    @Provides
    fun devicesUseCases(deviceRepository: DeviceRepository): DeviceUseCases = DeviceUseCases(
        getSavedDevices = GetDevices(deviceRepository)
    )
}