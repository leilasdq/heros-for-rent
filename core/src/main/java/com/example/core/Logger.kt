package com.example.core

import com.toxicbakery.logging.Arbor

/**
 * This class use to create a log in a simpler way over all modules
 * */

class Logger(
    private val tag: String,
    private val msg: String,
) {
    fun logDebugMsg() {
        Arbor.tag(tag).d(msg)
    }
    fun logErrorMsg() {
        Arbor.tag(tag).e(msg)
    }
}