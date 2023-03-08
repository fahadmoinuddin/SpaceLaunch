package com.fahad.astronaut_domain.di

import com.fahad.astronaut_domain.repository.IAstronautRepository
import com.fahad.astronaut_domain.usecase.AstronautUseCases
import com.fahad.astronaut_domain.usecase.GetAstronautDetailsUseCase
import com.fahad.astronaut_domain.usecase.GetAstronautListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class AstronautDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(repository: IAstronautRepository): AstronautUseCases {
        return AstronautUseCases(
            GetAstronautListUseCase(repository),
            GetAstronautDetailsUseCase(repository)
        )
    }
}