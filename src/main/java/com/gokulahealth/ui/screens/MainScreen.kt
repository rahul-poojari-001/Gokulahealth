package com.gokulahealth.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gokulahealth.ui.components.BottomNavigationBar

@Composable
fun MainScreen() {
    var currentRoute by remember { mutableStateOf("dashboard") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onNavigate = { route -> currentRoute = route }
            )
        }
    ) { padding ->
        Modifier.padding(padding).let {
            when (currentRoute) {
                "dashboard" -> DashboardScreen()
                "cattle" -> CattleListScreen()
                "milk" -> MilkDiaryScreen()
                "alerts" -> VaccinationScreen()
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        androidx.compose.material3.Text(text = title, fontSize = 24.sp)
    }
}
