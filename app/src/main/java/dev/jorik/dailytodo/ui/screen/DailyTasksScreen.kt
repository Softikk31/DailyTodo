package dev.jorik.dailytodo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jorik.dailytodo.domain.AppTime
import dev.jorik.dailytodo.domain.DailyItem
import dev.jorik.dailytodo.domain.Task
import dev.jorik.dailytodo.ui.screen.components.EditTaskDialog
import dev.jorik.dailytodo.ui.screen.components.TaskCard
import dev.jorik.dailytodo.ui.screen.components.TimeMarker
import dev.jorik.dailytodo.viewmodels.TasksViewModel

@Composable
fun DailyTasksScreen() {
    var selectedTask by remember { mutableStateOf<Task?>(null) }

    val tasksViewModel = TasksViewModel()
    val items: List<DailyItem> by tasksViewModel.tasks.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                when (item) {
                    is Task -> TaskCard(
                        task = item, onTaskClick = { selectedTask = item })

                    is AppTime -> TimeMarker(appTime = item)
                }
            }
        }
    }

    selectedTask?.let { task ->
        EditTaskDialog(
            task = task, onDismiss = { selectedTask = null })
    }
}

@Preview
@Composable
private fun DailyTasksScreenPreview() {
    DailyTasksScreen()
}