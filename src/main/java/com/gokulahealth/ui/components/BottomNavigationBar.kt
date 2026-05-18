package com.gokulahealth.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.gokulahealth.ui.theme.FarmGreen

import androidx.compose.ui.tooling.preview.Preview
import com.gokulahealth.ui.theme.GokulaHealthTheme

sealed class NavItem(val route: String, val icon: ImageVector, val label: String) {
    object Dashboard : NavItem("dashboard", Icons.Default.Dashboard, "Home")
    object Cattle : NavItem("cattle", Icons.AutoMirrored.Filled.List, "Cattle")
    object Milk : NavItem("milk", Icons.Default.WaterDrop, "Milk")
    object Alerts : NavItem("alerts", Icons.Default.Notifications, "Alerts")
}

@Composable
fun BottomNavigationBar(currentRoute: String, onNavigate: (String) -> Unit) {
    val items = listOf(
        NavItem.Dashboard,
        NavItem.Cattle,
        NavItem.Milk,
        NavItem.Alerts
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = FarmGreen
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = FarmGreen,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = FarmGreen,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    GokulaHealthTheme {
        BottomNavigationBar(currentRoute = "dashboard", onNavigate = {})
    }
}
