package com.fahad.astronaut_presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.usecase.AstronautUseCases
import com.fahad.core.common.Resource
import com.fahad.core.ui.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstronautDetailViewModel @Inject constructor(
    private val astronautUseCases: AstronautUseCases
): ViewModel() {

    private val _state = MutableStateFlow<UIState<Astronaut?>>(UIState.Idle())
    val state = _state.asStateFlow()

    fun getAstronautDetails(id: Int) {
        viewModelScope.launch {
            with(_state) {
                astronautUseCases
                    .getAstronautDetailsUseCase(id)
                    .onEach { resource ->
                        value = when (resource) {
                            is Resource.Success -> UIState.Success(resource.data)
                            is Resource.Error -> UIState.Error(resource.message)
                            is Resource.Loading -> UIState.Loading()
                        }
                    }
            }
        }
    }

}