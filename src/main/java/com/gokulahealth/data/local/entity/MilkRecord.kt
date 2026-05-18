package com.gokulahealth.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "milk_records")
data class MilkRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cattleId: Int,
    val date: Long,
    val morningYield: Float,
    val eveningYield: Float
)
