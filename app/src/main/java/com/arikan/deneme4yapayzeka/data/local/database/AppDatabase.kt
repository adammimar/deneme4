package com.arikan.deneme4yapayzeka.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arikan.deneme4yapayzeka.data.local.dao.ApartmentDao
import com.arikan.deneme4yapayzeka.data.local.dao.BuildingDao
import com.arikan.deneme4yapayzeka.data.local.dao.RoomDao
import com.arikan.deneme4yapayzeka.data.local.entities.ApartmentEntity
import com.arikan.deneme4yapayzeka.data.local.entities.BuildingEntity
import com.arikan.deneme4yapayzeka.data.local.entities.RoomEntity

@Database(
    entities = [BuildingEntity::class, ApartmentEntity::class, RoomEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun buildingDao(): BuildingDao
    abstract fun apartmentDao(): ApartmentDao
    abstract fun roomDao(): RoomDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "building_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
