package com.fahad.astronaut_data.repository

import com.fahad.astronaut_data.remote.AstronautApi
import com.fahad.astronaut_data.remote.invalidAstronautListResponse
import com.fahad.astronaut_data.remote.validAstronautListResponse
import com.fahad.core.common.JsonUtil
import com.google.common.truth.Truth.assertThat
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class AstronautRepositoryTest {

    private lateinit var repository: AstronautRepository
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: AstronautApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(JsonUtil.safeJson.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(AstronautApi::class.java)
        repository = AstronautRepository(
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Astronaut List, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validAstronautListResponse)
        )
        val result = repository.getAstronautList()
        assertThat(result.data).isNotEmpty()
    }

    @Test
    fun `Astronaut List, invalid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(429)
                .setBody(validAstronautListResponse)
        )
        val result = repository.getAstronautList()
        assertThat(result.message).isNotEmpty()
    }

    @Test
    fun `Astronaut List, malformed response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(invalidAstronautListResponse)
        )
        val result = repository.getAstronautList()
        assertThat(result.message).isNotEmpty()
    }
}