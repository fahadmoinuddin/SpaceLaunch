package com.fahad.astronaut_domain.usecase

import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource
import kotlinx.coroutines.flow.flow

// use case to get the details of an astronaut using their id
class GetAstronautListUseCase(
    private val astronautRepository: IAstronautRepository
) {
    suspend operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(astronautRepository.getAstronautList())
    }
}