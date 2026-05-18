package com.gokulahealth.data.local.dao

import androidx.room.*
import com.gokulahealth.data.local.entity.Cattle
import kotlinx.coroutines.flow.Flow

@Dao
interface CattleDao {
    @Query("SELECT * FROM cattle")
    fun getAllCattle(): Flow<List<Cattle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCattle(cattle: Cattle)

    @Delete
    suspend fun deleteCattle(cattle: Cattle)
}
