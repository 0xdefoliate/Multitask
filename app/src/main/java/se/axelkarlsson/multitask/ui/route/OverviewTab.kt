package se.axelkarlsson.multitask.ui.route

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import se.axelkarlsson.multitask.R
import se.axelkarlsson.multitask.util.Route
import se.axelkarlsson.multitask.util.Tab

@Serializable
object OverviewTab: Tab {
    override val label: String = "Overview"
    override val icon: Int = R.drawable.dashboard_24px

    override val ui = object: Route.UI {
        @Composable
        override fun Screen(callback: () -> Unit) {

        }
    }

}