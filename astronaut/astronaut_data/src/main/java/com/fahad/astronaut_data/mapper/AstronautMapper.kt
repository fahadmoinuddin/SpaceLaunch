package com.fahad.astronaut_data.mapper

import com.fahad.astronaut_data.remote.dto.AstronautDetail
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.core.enum.DateFormatEnum
import com.fahad.core.extension.toDate

// mapper function to transform repository model to domain model
fun AstronautDetail.toAstronaut() = Astronaut(
    id,
    name,
    nationality,
    bio,
    dateOfBirth.toDate(DateFormatEnum.Year_Month_Day),
    profileImageThumbnail

)
