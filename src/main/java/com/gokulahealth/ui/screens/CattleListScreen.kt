package com.gokulahealth.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gokulahealth.ui.theme.FarmGreen
import com.gokulahealth.ui.theme.FarmLightGreen

data class Cattle(val id: String, val name: String, val breed: String, val status: String)

@Composable
fun CattleListScreen() {
    val cattleList = listOf(
        Cattle("ID-12943", "Gauri", "Gir", "Healthy"),
        Cattle("ID-12944", "Laxmi", "Sahiwal", "Healthy"),
        Cattle("ID-12945", "Nandini", "Holstein", "Under Observation"),
        Cattle("ID-12946", "Kapila", "Jersey", "Healthy")
    )

    Scaffold(
        topBar = {
            CattleTopBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }, containerColor = FarmGreen) {
                Icon(Icons.Default.Add, contentDescription = "Add Cattle", tint = Color.White)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SearchBar()
            FilterRow()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(cattleList) { cattle ->
                    CattleItemCard(cattle)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CattleTopBar() {
    CenterAlignedTopAppBar(
        title = { Text("Registered Cattle", fontWeight = FontWeight.Bold) },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.FilterList, contentDescription = "Filter")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Search cattle by name or ID") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = FarmGreen,
            unfocusedBorderColor = Color.LightGray,
            cursorColor = FarmGreen
        )
    )
}

@Composable
fun FilterRow() {
    val filters = listOf("All", "Healthy", "Age", "Insemination", "Pregnant")
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filters) { filter ->
            FilterChip(
                selected = filter == "All",
                onClick = { /* TODO */ },
                label = { Text(filter) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = FarmGreen,
                    selectedLabelColor = Color.White
                )
            )
        }
    }
}

@Composable
fun CattleItemCard(cattle: Cattle) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for Cattle Image
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(FarmLightGreen),
                contentAlignment = Alignment.Center
            ) {
                Text("🐄", fontSize = 40.sp)
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(text = cattle.id, fontSize = 12.sp, color = Color.Gray)
                Text(text = cattle.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = cattle.breed, fontSize = 14.sp, color = FarmGreen)
            }
            
            StatusBadge(cattle.status)
        }
    }
}

@Composable
fun StatusBadge(status: String) {
    val color = if (status == "Healthy") FarmGreen else Color(0xFFF57C00)
    Surface(
        color = color.copy(alpha = 0.1f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = status,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = color,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
