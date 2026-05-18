package com.gokulahealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gokulahealth.ui.theme.FarmGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilkDiaryScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Milk Diary", fontWeight = FontWeight.Bold) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }, containerColor = FarmGreen) {
                Icon(Icons.Default.Add, contentDescription = "Add Entry", tint = Color.White)
            }
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
                YieldSummaryCard()
            }
            item {
                Text("Yield Trends (Last 7 Days)", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            item {
                YieldChartPlaceholder()
            }
            item {
                Text("Recent Entries", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            // Add entries here
            items(5) {
                YieldEntryItem("13 May 2026", "8.5L", "4.0L", "4.5L")
            }
        }
    }
}

@Composable
fun YieldSummaryCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = FarmGreen.copy(alpha = 0.1f))
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Monthly Average", color = Color.Gray, fontSize = 14.sp)
                Text("8.2 Liters", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = FarmGreen)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("Total this month", color = Color.Gray, fontSize = 14.sp)
                Text("246 L", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = FarmGreen)
            }
        }
    }
}

@Composable
fun YieldChartPlaceholder() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text("MPAndroidChart will be here", color = Color.LightGray)
        }
    }
}

@Composable
fun YieldEntryItem(date: String, total: String, morning: String, evening: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(date, fontWeight = FontWeight.Bold)
                Text("M: $morning | E: $evening", fontSize = 12.sp, color = Color.Gray)
            }
            Text(total, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = FarmGreen)
        }
    }
}
