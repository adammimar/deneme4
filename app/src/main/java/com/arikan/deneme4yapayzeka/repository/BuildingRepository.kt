package com.arikan.deneme4yapayzeka.repository


import com.arikan.deneme4yapayzeka.data.local.dao.BuildingDao
import com.arikan.deneme4yapayzeka.data.local.entities.BuildingEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildingRepository @Inject constructor(
    private val buildingDao: BuildingDao
) {
    fun getAllBuildings(): Flow<List<BuildingEntity>> = buildingDao.getAllBuildings()

    suspend fun insertBuilding(building: BuildingEntity) {
        buildingDao.insertBuilding(building)
    }

    suspend fun deleteBuilding(building: BuildingEntity) {
        buildingDao.deleteBuilding(building)
    }
}
