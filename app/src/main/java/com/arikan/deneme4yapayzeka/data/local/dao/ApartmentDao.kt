package com.arikan.deneme4yapayzeka.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arikan.deneme4yapayzeka.data.local.entities.ApartmentEntity

@Dao
interface ApartmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment(apartment: ApartmentEntity)

    @Query("SELECT * FROM apartments WHERE buildingId = :buildingId")
    suspend fun getApartmentsByBuilding(buildingId: Int): List<ApartmentEntity>

    @Delete
    suspend fun deleteApartment(apartment: ApartmentEntity)
}
