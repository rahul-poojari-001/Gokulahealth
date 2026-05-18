package com.gokulahealth.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gokulahealth.ui.theme.FarmGreen
import com.gokulahealth.ui.theme.FarmLightGreen

@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            DashboardTopBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                WelcomeSection()
            }
            item {
                RecentlyViewedRow()
            }
            item {
                StatsGrid()
            }
            item {
                SectionHeader("Active Tasks")
            }
            // Add task items here
            item {
                TaskCard("Vaccination due for Cow #12", "Tomorrow", Icons.Default.Notifications, Color(0xFFFFEBEE), Color(0xFFD32F2F))
            }
            item {
                TaskCard("Milk yield low for Cow #05", "Check status", Icons.Default.TrendingDown, Color(0xFFFFF3E0), Color(0xFFF57C00))
            }
        }
    }
}

@Composable
fun DashboardTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hello, Farmer!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = FarmGreen
            )
            Text(
                text = "Sunday, 13 May 2026",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.AccountCircle, contentDescription = "Profile", modifier = Modifier.size(32.dp))
        }
    }
}

@Composable
fun WelcomeSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = FarmGreen)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text("Your Farm at a Glance", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Everything looks good today. 12 cattle registered.", color = Color.White.copy(alpha = 0.8f))
        }
    }
}

@Composable
fun RecentlyViewedRow() {
    Column {
        Text("Recently Viewed", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(5) { index ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(FarmLightGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🐄", fontSize = 24.sp)
                    }
                    Text("Cow #0${index + 1}", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun StatsGrid() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        StatCard("Total Cattle", "12", Icons.Default.Pets, Modifier.weight(1f))
        StatCard("Avg Yield", "8.5L", Icons.Default.WaterDrop, Modifier.weight(1f))
    }
}

@Composable
fun StatCard(title: String, value: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = null, tint = FarmGreen)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = title, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun TaskCard(title: String, subtitle: String, icon: ImageVector, bgColor: Color, iconColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = iconColor)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = subtitle, fontSize = 12.sp, color = iconColor)
            }
        }
    }
}
