package com.knightshrestha.neonnovels.datasources.local.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem
import kotlinx.coroutines.launch

class LocalViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: LocalRepo
    val allBooks: LiveData<List<LocalSeriesItem>>

    init {
        val dao = LocalDatabase.getDatabase(application).localDAO()
        repository = LocalRepo(dao)
        allBooks = repository.getAllSeries()
    }

    fun insertLocalItem(localSeriesItem: LocalSeriesItem) {
        viewModelScope.launch {
            repository.insertSeries(localSeriesItem)
        }
    }
}