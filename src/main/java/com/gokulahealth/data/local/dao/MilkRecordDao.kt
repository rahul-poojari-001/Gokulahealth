package com.gokulahealth.data.local.dao

import androidx.room.*
import com.gokulahealth.data.local.entity.MilkRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface MilkRecordDao {
    @Query("SELECT * FROM milk_records WHERE cattleId = :cattleId ORDER BY date DESC")
    fun getMilkRecordsForCattle(cattleId: Int): Flow<List<MilkRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMilkRecord(record: MilkRecord)
}
