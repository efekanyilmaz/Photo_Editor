package com.efecjo.photoeditor.util

import timber.log.Timber

class CustomDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String {
        return "Photo Editor:${super.createStackElementTag(element)}:${element.lineNumber}"
    }
}