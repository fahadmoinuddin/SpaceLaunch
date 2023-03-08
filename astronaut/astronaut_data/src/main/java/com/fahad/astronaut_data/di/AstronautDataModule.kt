package com.fahad.astronaut_data.di

import com.fahad.astronaut_data.remote.AstronautApi
import com.fahad.astronaut_data.repository.AstronautRepository
import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AstronautDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideAstronautApi(client: OkHttpClient): AstronautApi {
        return Retrofit.Builder()
            .baseUrl(AstronautApi.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
            .create(AstronautApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAstronautRepository(api: AstronautApi): IAstronautRepository {
        return AstronautRepository(api)
    }
}