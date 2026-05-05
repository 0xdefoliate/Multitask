package se.axelkarlsson.multitask.ui.route

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import se.axelkarlsson.multitask.R
import se.axelkarlsson.multitask.util.Route
import se.axelkarlsson.multitask.util.Tab

@Serializable
object RoutinesTab : Tab {
    override val label = "Routines"
    override val icon = R.drawable.autopause_24px

    override val ui = object: Route.UI {
        @Composable
        fun AddRoutineFloatingButton(onClick: () -> Unit) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingActionButton(
                    modifier = Modifier
                        .padding(16.dp),
                    onClick = onClick
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add_24px),
                        contentDescription = "Add Routine"
                    )
                }
            }
        }

        @Composable
        override fun Screen(callback: () -> Unit) {
            AddRoutineFloatingButton(onClick = callback)
        }
    }

}