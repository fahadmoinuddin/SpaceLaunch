package com.fahad.astronaut_domain.usecase

// collection of all use cases in this module
data class AstronautUseCases(
    val getAstronautListUseCase: GetAstronautListUseCase,
    val getAstronautDetailsUseCase: GetAstronautDetailsUseCase
)
