package com.fahad.astronaut_domain.repository

import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.core.common.Resource

/**
 * Creating Repository abstraction in domain as domain cant access data or presentation modules.
 * This will help in testing domain usecases
 */
interface IAstronautRepository {
    suspend fun getAstronautList(): Resource<List<Astronaut>?>
    suspend fun getAstronautDetail(id: Int): Resource<Astronaut?>
}
