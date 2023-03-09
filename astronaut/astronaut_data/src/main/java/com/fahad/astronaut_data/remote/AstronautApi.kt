package com.fahad.astronaut_data.remote

import com.fahad.astronaut_data.remote.dto.AstronautDetail
import com.fahad.astronaut_data.remote.dto.AstronautList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AstronautApi {

    companion object {
        const val BASE_URL = "https://spacelaunchnow.me/api/3.5.0/"
    }

    @GET("astronaut?limit=20")
    suspend fun getAstronautList(): Response<AstronautList>

    @GET("astronaut/{astronautId}")
    suspend fun getAstronautDetails(@Path("astronautId") astronautId: Int): Response<AstronautDetail>
}