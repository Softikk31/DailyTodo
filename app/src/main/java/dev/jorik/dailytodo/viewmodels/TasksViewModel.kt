package dev.jorik.dailytodo.viewmodels

import androidx.lifecycle.ViewModel
import dev.jorik.dailytodo.domain.AppTime
import dev.jorik.dailytodo.domain.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TasksViewModel : ViewModel() {
    private val _tasks = MutableStateFlow(
        listOf(
            Task(id = 1, title = "Помыть посуду", completed = false),
            AppTime(time = "13:19", delta = 0),
            Task(id = 2, title = "Развесить стирку", completed = false),
            AppTime(time = "14:00", delta = -10),
            Task(id = 3, title = "Купить продукты", completed = false),
            Task(id = 4, title = "Выкинуть мусор", completed = false),
            Task(id = 5, title = "Погулять с собакой", completed = false)
        )
    )

    val tasks = _tasks.asStateFlow()
}