package com.fahad.astronaut_domain.usecase

import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource
import kotlinx.coroutines.flow.flow

// use case to get the list of astronauts
class GetAstronautDetailsUseCase(
    private val astronautRepository: IAstronautRepository
) {
    suspend operator fun invoke(id: Int) = flow {
        emit(Resource.Loading())
        if (id <= 0)
            emit(Resource.Error("id cannot be empty"))
        else
            emit(astronautRepository.getAstronautDetail(id))
    }
}