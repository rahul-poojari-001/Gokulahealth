package com.gokulahealth.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gokulahealth.data.local.dao.CattleDao
import com.gokulahealth.data.local.dao.MilkRecordDao
import com.gokulahealth.data.local.entity.Cattle
import com.gokulahealth.data.local.entity.MilkRecord
import com.gokulahealth.data.local.entity.VaccinationRecord

@Database(entities = [Cattle::class, MilkRecord::class, VaccinationRecord::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cattleDao(): CattleDao
    abstract fun milkRecordDao(): MilkRecordDao
}
