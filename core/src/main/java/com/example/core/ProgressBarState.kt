package com.example.core

sealed class ProgressBarState {
    object LOADING: ProgressBarState()
    object IDLE: ProgressBarState()
}