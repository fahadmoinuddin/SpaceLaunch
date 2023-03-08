package com.fahad.core.extension

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectOnStarted(
    lifecycleOwner: LifecycleOwner,
    crossinline action: (T) -> Unit
) = lifecycleOwner.lifecycleScope.launch {
    lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
        collect {
            action(it)
        }
    }
}