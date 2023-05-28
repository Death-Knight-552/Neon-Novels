package com.knightshrestha.neonnovels.datasources.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem

@Database(entities = [LocalSeriesItem::class], version = 1, exportSchema = false)
@TypeConverters(DateConverters::class, ListConverters::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDAO(): LocalDAO

    companion object {

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, LocalDatabase::class.java, "Origin"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}