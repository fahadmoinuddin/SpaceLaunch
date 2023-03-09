package com.fahad.core.common

import kotlinx.serialization.json.Json

object JsonUtil {
    val safeJson = Json {
        ignoreUnknownKeys = true
    }
}