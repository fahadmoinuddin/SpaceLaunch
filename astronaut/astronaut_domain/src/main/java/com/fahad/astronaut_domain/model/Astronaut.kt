package com.fahad.astronaut_domain.model

import android.os.Parcelable
import java.util.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class Astronaut(
    val id: Int,
    val name: String,
    val nationality: String,
    val bio: String?,
    val dateOfBirth: Date?,
    val profileImageThumbnail: String?
) : Parcelable
