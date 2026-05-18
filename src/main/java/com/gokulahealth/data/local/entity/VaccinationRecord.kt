package com.gokulahealth.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccination_records")
data class VaccinationRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cattleId: Int,
    val vaccineName: String,
    val date: Long,
    val nextDueDate: Long
)
