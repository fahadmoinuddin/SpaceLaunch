package com.fahad.astronaut_data.repository

import com.fahad.astronaut_data.mapper.toAstronaut
import com.fahad.astronaut_data.remote.AstronautApi
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.APIUtil.parseResponse
import com.fahad.core.common.Resource

class AstronautRepository(
    private val api: AstronautApi
) : IAstronautRepository {

    override suspend fun getAstronautList(): Resource<List<Astronaut>?> {
        return try {
            parseResponse(api.getAstronautList()) {
                it?.results?.map { it.toAstronaut() }.orEmpty()
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }

    override suspend fun getAstronautDetail(id: Int): Resource<Astronaut?> {
        return try {
            parseResponse(api.getAstronautDetails(id)) {
                it?.toAstronaut()
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }
}
