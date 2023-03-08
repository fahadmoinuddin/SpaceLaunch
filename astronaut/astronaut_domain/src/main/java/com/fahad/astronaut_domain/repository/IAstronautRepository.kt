package com.fahad.astronaut_domain.repository

import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.core.common.Resource

interface IAstronautRepository {
    suspend fun getAstronautList(): Resource<List<Astronaut>?>
    suspend fun getAstronautDetail(id: Int): Resource<Astronaut?>
}