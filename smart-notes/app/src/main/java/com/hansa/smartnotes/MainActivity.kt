package com.hansa.smartnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hansa.smartnotes.model.Note
import com.hansa.smartnotes.ui.components.NoteCard
import com.hansa.smartnotes.ui.theme.SmartNotesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SmartNotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NoteCard(
                        note = Note(
                            id = 1,
                            title = "Android learning plan",
                            content = "Learn Kotlin, Jetpack Compose, Room, ViewModel, and Android testing.",
                            updatedAt = "Updated today"
                        ),
                        onClick = {
                            println("Note card clicked")
                        },
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
