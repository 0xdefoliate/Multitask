package se.axelkarlsson.multitask.route.addroutine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun AddRoutineScreen(callback: () -> Unit = {}) {
    var description by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
    ) {
        OutlinedTextField(
            modifier = Modifier.Companion
                .fillMaxWidth(),
            label = {
                Text("Description")
            },
            placeholder = {
                Text(
                    "turn on Aeroplane Mode at 5 P.M.",
                    fontStyle = FontStyle.Companion.Italic
                )
            },
            value = description,
            onValueChange = { description = it },
            maxLines = 1
        )
    }
}