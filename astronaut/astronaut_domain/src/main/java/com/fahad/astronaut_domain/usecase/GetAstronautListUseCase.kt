package com.fahad.astronaut_domain.usecase

import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.core.common.Resource
import kotlinx.coroutines.flow.flow

class GetAstronautListUseCase(
    private val astronautRepository: IAstronautRepository
) {
    suspend operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(astronautRepository.getAstronautList())
    }
}