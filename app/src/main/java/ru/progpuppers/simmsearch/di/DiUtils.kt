package ru.progpuppers.simmsearch.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class JsonResponseFactory

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class JsonRequestFactory