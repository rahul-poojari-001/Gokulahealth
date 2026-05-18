package com.gokulahealth.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cattle")
data class Cattle(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val earTagId: String,
    val photoUri: String? = null
)
