package com.fahad.core.ui

/**
 * State to display the UI
 */
sealed interface UIState<T> {
    class Success<T>(val data: T) : UIState<T>
    class Error<T>(val message: String?) : UIState<T>
    class Loading<T> : UIState<T>
    class Idle<T> : UIState<T>
}
