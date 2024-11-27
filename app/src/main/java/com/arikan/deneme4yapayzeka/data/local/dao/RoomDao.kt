package com.arikan.deneme4yapayzeka.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arikan.deneme4yapayzeka.data.local.entities.RoomEntity

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: RoomEntity)

    @Query("SELECT * FROM rooms WHERE apartmentId = :apartmentId")
    suspend fun getRoomsByApartment(apartmentId: Int): List<RoomEntity>

    @Query("UPDATE rooms SET coordinates = :coordinates WHERE id = :roomId")
    suspend fun updateCoordinates(roomId: Int, coordinates: String)

    @Delete
    suspend fun deleteRoom(room: RoomEntity)
}
