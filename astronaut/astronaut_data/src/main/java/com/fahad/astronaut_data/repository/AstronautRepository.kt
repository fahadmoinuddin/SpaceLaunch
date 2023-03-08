package com.fahad.astronaut_data.repository

import com.fahad.astronaut_data.mapper.toAstronaut
import com.fahad.astronaut_data.remote.AstronautApi
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource

class AstronautRepository(
    private val api: AstronautApi
): IAstronautRepository {

    override suspend fun getAstronautList(): Resource<List<Astronaut>?> {
        return try {
            val response = api.getAstronautList()
            if (response.isSuccessful) {
                Resource.Success(response.body()?.results?.map { it.toAstronaut() }.orEmpty())
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.localizedMessage.orEmpty())
        }
    }

    override suspend fun getAstronautDetail(id: Int): Resource<Astronaut?> {
        return try {
            val response = api.getAstronautDetails(id)
            if (response.isSuccessful) {
                Resource.Success(response.body()?.toAstronaut())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage.orEmpty())
        }
    }

}