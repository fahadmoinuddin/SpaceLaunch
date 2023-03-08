package com.fahad.astronaut_data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class AstronautDetail(
    val id: Int,
    val name: String,
    val nationality: String,
    val bio: String?,
    @SerialName("date_of_birth")
    val dateOfBirth: String?,
    @SerialName("profile_image")
    val profileImage: String?,
    @SerialName("profile_image_thumbnail")
    val profileImageThumbnail: String?
)
