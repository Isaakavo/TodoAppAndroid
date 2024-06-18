package com.manuelhaas.todo.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


import com.manuelhaas.todo.ui.theme.components.TodoCard
import com.manuelhaas.todo.ui.theme.navigation.AppScreens
import com.manuelhaas.todo.ui.theme.viewmodel.TodoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, todoViewModel: TodoViewModel = viewModel()) {
    val todos by remember { mutableStateOf(todoViewModel.todos) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(bottom = 10.dp),
                navigationIcon = {
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Column {
                        Text(
                            "My Day",
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(
                                "30 de Agosto",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primaryContainer
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(route = AppScreens.TodoScreen.route) },
                modifier = Modifier.padding(end = 35.dp, bottom = 10.dp),
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.primaryContainer
            )
            {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(todoList) {todoItem ->
                val isFavorite = remember {
                    mutableStateOf(false)
                }
                val checked = remember {
                    mutableStateOf(false)
                }
                TodoCard(
                    todoName = todoItem.todoName,
                    tag = todoItem.tag,
                    todoDate = todoItem.todoDate,
                    checked = checked.value,
                    isFavorite = isFavorite.value,
                    onFavoriteClick = { it -> isFavorite.value = it },
                    onCheckedChange = { it -> checked.value = it },
                )
            }
        }
    }
}


data class Todo(
    val todoName: String,
    val tag: String,
    val todoDate: String
)

val todoList = listOf(
    Todo(todoName = "Todo 1", tag = "Home", todoDate = "22 de marzo"),
    Todo(todoName = "Todo 2", tag = "School", todoDate = "30 de agost"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 1", tag = "Home", todoDate = "22 de marzo"),
    Todo(todoName = "Todo 2", tag = "School", todoDate = "30 de agosto"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
    Todo(todoName = "Todo 3", tag = "Home", todoDate = "5 de marzo"),
)


