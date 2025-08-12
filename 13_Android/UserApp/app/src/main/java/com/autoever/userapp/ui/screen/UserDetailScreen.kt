package com.autoever.userapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.autoever.userapp.viewmodel.UserViewModel

@Composable
fun UserDetailScreen(viewModel: UserViewModel, userId: Long, navController: NavController) {
    val selectedUser by viewModel.selectedUser.collectAsState()

    LaunchedEffect(userId) {
        viewModel.getUser(userId)
    }

    selectedUser?.let { user ->
        var name by remember { mutableStateOf(user.name) }
        var email by remember { mutableStateOf(user.email) }

        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )
            Spacer(Modifier.height(8.dp))
            Row {
                Button(onClick = {
                    viewModel.updateUser(userId, name, email)
                    navController.popBackStack()
                }) {
                    Text("Update")
                }
                Spacer(Modifier.width(8.dp))
                Button(onClick = {
                    viewModel.deleteUser(userId)
                    navController.popBackStack()
                }) {
                    Text("Delete")
                }
            }
        }
    }
}