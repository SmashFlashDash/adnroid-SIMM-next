package ru.progpuppers.simmsearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.data.bthapi.BthApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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

    @Singleton
    @Provides
    fun bthApi(
        @JsonRequestFactory jsonRequestFactory:Json,
        @JsonRequestFactory jsonResponseFactory:Json
    ): BthApi = BthApi(jsonRequestFactory, jsonResponseFactory)
}