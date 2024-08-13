package ru.progpuppers.simmsearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import ru.progpuppers.simmsearch.domain.repository.DeviceRepositoryImpl
import ru.progpuppers.simmsearch.domain.usecases.DeviceUseCases
import ru.progpuppers.simmsearch.domain.usecases.GetDevices
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun bthApi(): BthApi = BthApi(
        Json { encodeDefaults = false },
        Json {
            encodeDefaults = false
            explicitNulls = false
            classDiscriminator = "cmd"
        }
    )

    @Singleton
    @Provides
    fun deviceRepository(bthApi: BthApi): DeviceRepository = DeviceRepositoryImpl(
        bthApi
    )

    @Singleton
    @Provides
    fun devicesUseCases(deviceRepository: DeviceRepository): DeviceUseCases = DeviceUseCases(
        getSavedDevices = GetDevices(deviceRepository)
    )
}