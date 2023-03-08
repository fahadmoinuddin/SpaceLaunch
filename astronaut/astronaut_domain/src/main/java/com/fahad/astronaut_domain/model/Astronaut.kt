package com.fahad.astronaut_domain.model

import java.util.*

data class Astronaut(
    val id: Int,
    val name: String,
    val nationality: String,
    val bio: String?,
    val dateOfBirth: Date?,
    val profileImage: String?,
    val profileImageThumbnail: String?
)
