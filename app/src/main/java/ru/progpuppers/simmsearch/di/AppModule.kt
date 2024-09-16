package ru.progpuppers.simmsearch.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.app.BuildConfig
import ru.progpuppers.simmsearch.data.MockData
import ru.progpuppers.simmsearch.data.bthapi.BluetoothControllerImpl
import ru.progpuppers.simmsearch.data.bthapi.BluetoothControllerMockImpl
import ru.progpuppers.simmsearch.data.database.AppDatabase
import ru.progpuppers.simmsearch.data.database.DeviceRepositoryImpl
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.repository.DeviceRepository
import ru.progpuppers.simmsearch.domain.usecases.DeviceUseCases
import ru.progpuppers.simmsearch.domain.usecases.GetDevices
import javax.inject.Singleton

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
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController =
        releaseOrDebugImpl(
            releaseImpl = {
                BluetoothControllerImpl(
                    context,
                    jsonRequestFactory,
                    jsonResponseFactory
                )
            },
            debugImpl = {
                BluetoothControllerMockImpl(
                    context,
                    jsonRequestFactory,
                    jsonResponseFactory
                )
            }
        )

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase = Room
        .databaseBuilder(app, AppDatabase::class.java, "parking_spots.db")
        .build()

    @Singleton
    @Provides
    fun provideDeviceRepository(db: AppDatabase): DeviceRepository {
        val repository = DeviceRepositoryImpl(db.dao)
        if (BuildConfig.BUILD_TYPE == "debug") {
            MockData.initToDeviceRepository(repository)
        }
        return repository
    }

    // todo: нафиг нужен лишний уровень
    @Singleton
    @Provides
    fun devicesUseCases(deviceRepository: DeviceRepository): DeviceUseCases = DeviceUseCases(
        getSavedDevices = GetDevices(deviceRepository)
    )

    private fun <T> releaseOrDebugImpl(releaseImpl: () -> T, debugImpl: () -> T): T =
        if (BuildConfig.BUILD_TYPE == "release") releaseImpl() else debugImpl()
}
