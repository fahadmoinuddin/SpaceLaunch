package com.fahad.astronaut_data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AstronautList(
    val results: List<AstronautDetail>?
)
