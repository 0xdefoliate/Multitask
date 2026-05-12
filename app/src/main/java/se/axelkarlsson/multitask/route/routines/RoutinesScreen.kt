package se.axelkarlsson.multitask.route.routines

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
import se.axelkarlsson.multitask.R

@Composable
private fun AddRoutineFloatingButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier.Companion
            .fillMaxSize(),
        contentAlignment = Alignment.Companion.BottomEnd
    ) {
        FloatingActionButton(
            modifier = Modifier.Companion
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
fun RoutinesScreen(callback: () -> Unit) {
    AddRoutineFloatingButton(onClick = callback)
}