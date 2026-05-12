package se.axelkarlsson.multitask.route.routines

import kotlinx.serialization.Serializable
import se.axelkarlsson.multitask.R
import se.axelkarlsson.multitask.util.Tab

@Serializable
object RoutinesRoute: Tab {
    override val label = "Routines"
    override val icon = R.drawable.autopause_24px
}