package com.knightshrestha.neonnovels.datasources.local.database

import androidx.lifecycle.LiveData
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem

class LocalRepo(private val localDAO: LocalDAO) {
      fun getAllSeries(): LiveData<List<LocalSeriesItem>> {
        return localDAO.getAllItems()
    }

    suspend fun updateSeries(localSeriesItem: LocalSeriesItem) {
        localDAO.updateWithTimestamp(localSeriesItem)
    }

    suspend fun insertSeries(localSeriesItem: LocalSeriesItem) {
        localDAO.insertWithTimestamp(localSeriesItem)
    }



}