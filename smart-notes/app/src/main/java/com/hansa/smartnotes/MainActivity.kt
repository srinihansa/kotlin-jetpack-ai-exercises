package com.hansa.smartnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hansa.smartnotes.model.Note
import com.hansa.smartnotes.ui.components.NoteCard
import com.hansa.smartnotes.ui.theme.SmartNotesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleNotes = listOf(
            Note(
                id = 1,
                title = "Android learning plan",
                content = "Learn Kotlin, Jetpack Compose, Room, ViewModel, and Android testing.",
                updatedAt = "Updated today"
            ),
            Note(
                id = 2,
                title = "DevOps checklist",
                content = "Build the app, run tests, generate the APK, and publish the artifact.",
                updatedAt = "Updated yesterday"
            ),
            Note(
                id = 3,
                title = "Compose fundamentals",
                content = "Practice composables, state, modifiers, layouts, and reusable UI components.",
                updatedAt = "Updated 2 days ago"
            ),
            Note(
                id = 4,
                title = "Project ideas",
                content = "Smart Notes, weather app, expense tracker, and AI document assistant.",
                updatedAt = "Updated last week"
            ),
        Note(
            id = 5,
            title = "Test SCROLL 1",
            content = "Learn Kotlin, Jetpack Compose, Room, ViewModel, and Android testing.",
            updatedAt = "Updated today"
        ),
        Note(
            id = 6,
            title = "Test SCROLL 2",
            content = "Build the app, run tests, generate the APK, and publish the artifact.",
            updatedAt = "Updated yesterday"
        ),
        Note(
            id = 7,
            title = "Test SCROLL 3",
            content = "Practice composables, state, modifiers, layouts, and reusable UI components.",
            updatedAt = "Updated 2 days ago"
        ),
        Note(
            id = 8,
            title = "Test SCROLL 4",
            content = "Smart Notes, weather app, expense tracker, and AI document assistant.",
            updatedAt = "Updated last week"
        )
        )

        setContent {
            SmartNotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = sampleNotes,
                            key = { note -> note.id }
                        ) { note ->
                            NoteCard(
                                note = note,
                                onClick = {
                                    println("Clicked note: ${note.title}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
