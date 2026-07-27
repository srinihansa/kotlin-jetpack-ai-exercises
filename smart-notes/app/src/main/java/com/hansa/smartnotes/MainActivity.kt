package com.hansa.smartnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            )
        )

        setContent {
            SmartNotesTheme {
                var searchQuery by remember {
                    mutableStateOf("")
                }

                val filteredNotes = sampleNotes.filter { note ->
                    note.title.contains(
                        other = searchQuery,
                        ignoreCase = true
                    ) ||
                    note.content.contains(
                        other = searchQuery,
                        ignoreCase = true
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { newValue ->
                                searchQuery = newValue
                            },
                            label = {
                                Text(text = "Search notes")
                            },
                            placeholder = {
                                Text(text = "Search by title or content")
                            },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 16.dp,
                                    top = 16.dp,
                                    end = 16.dp,
                                    bottom = 8.dp
                                )
                        )

                        if (filteredNotes.isEmpty()) {
                            Text(
                                text = "No notes found for \"$searchQuery\"",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(16.dp)
                            )
                        } else {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(
                                    start = 16.dp,
                                    top = 8.dp,
                                    end = 16.dp,
                                    bottom = 16.dp
                                ),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                items(
                                    items = filteredNotes,
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
    }
}
