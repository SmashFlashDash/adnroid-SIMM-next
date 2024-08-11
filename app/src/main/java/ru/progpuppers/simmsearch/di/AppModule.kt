package ru.progpuppers.simmsearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.data.bthapi.BthService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @JsonRequestFactory
    fun bthService(): BthService = BthService()

    @Singleton
    @Provides
    @JsonRequestFactory
    fun jsonRequestFactory(): Json {
        return Json {
            encodeDefaults = false
        }
    }

    @Singleton
    @Provides
    @JsonResponseFactory
    fun jsonResponseFactory(): Json {
        return Json {
            encodeDefaults = false
            explicitNulls = false
            classDiscriminator = "cmd"
        }
    }
}