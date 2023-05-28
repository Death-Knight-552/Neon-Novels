package com.knightshrestha.neonnovels.datasources.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem

@Dao
abstract class LocalDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun  insert(localSeriesItem: LocalSeriesItem)
    suspend fun insertWithTimestamp(localSeriesItem: LocalSeriesItem) {
        insert(localSeriesItem.apply{
            createdAt = System.currentTimeMillis()
            updatedAt = System.currentTimeMillis()
        })
    }


    @Update
    abstract suspend fun update(localSeriesItem: LocalSeriesItem)
    suspend fun updateWithTimestamp(localSeriesItem: LocalSeriesItem) {
        insert(localSeriesItem.apply{
            updatedAt = System.currentTimeMillis()
        })
    }

    @Query("SELECT * FROM `Series Items`")
    abstract fun getAll(): LiveData<List<LocalSeriesItem>>
    fun getAllItems(): LiveData<List<LocalSeriesItem>> {
        return getAll()
    }
}