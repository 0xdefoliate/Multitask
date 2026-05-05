package se.axelkarlsson.multitask.util

import androidx.compose.runtime.Composable



interface Route {
    interface UI {
        @Composable fun Screen(callback: () -> Unit = {}): Unit
    }

    val ui: UI
}

