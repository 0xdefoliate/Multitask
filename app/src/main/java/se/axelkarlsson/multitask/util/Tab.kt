package se.axelkarlsson.multitask.util

import androidx.annotation.DrawableRes

interface Tab: Route {
    val label: String
    val icon: Int
}