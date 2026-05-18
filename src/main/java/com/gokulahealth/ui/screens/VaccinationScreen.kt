package com.gokulahealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
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
fun VaccinationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Vaccination Alerts", fontWeight = FontWeight.Bold) })
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
                AlertBanner("FMD Vaccination due in 2 days for 5 cattle.")
            }
            item {
                Text("Upcoming Vaccinations", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            items(3) { index ->
                VaccinationCard("Cattle #0${index + 1}", "FMD Booster", "15 May 2026")
            }
            item {
                Text("Recent History", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            items(2) { index ->
                VaccinationCard("Cattle #12", "Anthrax", "01 May 2026", completed = true)
            }
        }
    }
}

@Composable
fun AlertBanner(message: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE))
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.Red)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = message, color = Color.Red, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun VaccinationCard(cattle: String, vaccine: String, date: String, completed: Boolean = false) {
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
                Text(cattle, fontWeight = FontWeight.Bold)
                Text(vaccine, fontSize = 14.sp, color = FarmGreen)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(date, fontSize = 12.sp, color = Color.Gray)
                if (completed) {
                    Text("Completed", fontSize = 12.sp, color = FarmGreen, fontWeight = FontWeight.Bold)
                } else {
                    Text("Pending", fontSize = 12.sp, color = Color.Red, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
