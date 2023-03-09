package com.fahad.astronaut_presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_domain.usecase.AstronautUseCases
import com.fahad.core.common.Resource
import com.fahad.core.ui.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstronautListViewModel @Inject constructor(
    private val astronautUseCases: AstronautUseCases
) : ViewModel() {

    enum class SortOptions {
        NAME
    }

    private val _state = MutableStateFlow<UIState<List<Astronaut>?>>(UIState.Idle())
    val state = _state.asStateFlow()

    val hasData: Boolean
    get() = (_state.value as? UIState.Success)?.data.isNullOrEmpty().not()

    fun sortListBy(sortOption: SortOptions) {
        (_state.value as? UIState.Success)?.data?.apply {
            _state.value = when (sortOption) {
                SortOptions.NAME -> UIState.Success(sortedBy { it.name })
            }
        }
    }

    fun getAstronautList() {
        viewModelScope.launch {
            with(_state) {
                astronautUseCases
                    .getAstronautListUseCase()
                    .collect { resource ->
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