package se.axelkarlsson.multitask.route.overview

import kotlinx.serialization.Serializable
import se.axelkarlsson.multitask.R
import se.axelkarlsson.multitask.util.Tab

@Serializable
object OverviewRoute: Tab {
    override val label: String = "Overview"
    override val icon: Int = R.drawable.dashboard_24px
}