package se.axelkarlsson.multitask.ui.route

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import se.axelkarlsson.multitask.util.Route

@Serializable
object AddRoutineRoute : Route {
    override val ui = object : Route.UI {
        @Composable
        override fun Screen(callback: () -> Unit) {

            var description by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text("Description")
                    },
                    placeholder = {
                        Text(
                            "turn on Aeroplane Mode at 5 P.M.",
                            fontStyle = FontStyle.Italic
                        )
                    },
                    value = description,
                    onValueChange = { description = it },
                    maxLines = 1
                )
            }
        }
    }
}