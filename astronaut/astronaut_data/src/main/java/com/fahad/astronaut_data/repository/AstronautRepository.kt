package com.fahad.astronaut_data.repository

import com.fahad.astronaut_data.mapper.toAstronaut
import com.fahad.astronaut_data.remote.AstronautApi
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource
import retrofit2.Response

class AstronautRepository(
    private val api: AstronautApi
): IAstronautRepository {

    private fun <I, O> parseResponse(response: Response<I>, mapper: (I?) -> O): Resource<O> {
        return try {
            if (response.isSuccessful) {
                Resource.Success(mapper(response.body()))
            } else {
                Resource.Error(response.errorBody()?.string())
            }
        } catch(e: Exception) {
            Resource.Error(e.localizedMessage.orEmpty())
        }
    }

    override suspend fun getAstronautList(): Resource<List<Astronaut>?> {
        return parseResponse(api.getAstronautList()) {
            it?.results?.map { it.toAstronaut() }.orEmpty()
        }
    }

    override suspend fun getAstronautDetail(id: Int): Resource<Astronaut?> {
        return parseResponse(api.getAstronautDetails(id)) {
            it?.toAstronaut()
        }
    }

}