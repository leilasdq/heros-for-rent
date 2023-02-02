package com.example.core

sealed class Result<T> {
    data class SUCCESS<T>(val data: T? = null) : Result<T>()

    data class LOADING<T>(
        val progressState: ProgressBarState = ProgressBarState.IDLE
    ) : Result<T>()

    data class ERROR<T>(val data: T? = null, val message: Throwable) : Result<T>()
}