package com.arikan.deneme4yapayzeka.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "rooms",
    foreignKeys = [
        ForeignKey(
            entity = ApartmentEntity::class,
            parentColumns = ["id"],
            childColumns = ["apartmentId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["apartmentId"])]
)
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val color: String, // Örnek: "#FF5733"
    val thickness: Float, // Çizgi kalınlığı
    val coordinates: String, // JSON formatında tutulabilir
    val apartmentId: Int
)
