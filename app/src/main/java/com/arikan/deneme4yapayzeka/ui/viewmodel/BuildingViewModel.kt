package com.arikan.deneme4yapayzeka.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arikan.deneme4yapayzeka.data.local.entities.BuildingEntity
import com.arikan.deneme4yapayzeka.repository.BuildingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuildingViewModel @Inject constructor(
    private val repository: BuildingRepository
) : ViewModel() {

    private val _buildings = MutableStateFlow<List<BuildingEntity>>(emptyList())
    val buildings: StateFlow<List<BuildingEntity>> = _buildings.asStateFlow()

    init {
        loadBuildings()
    }

    private fun loadBuildings() {
        viewModelScope.launch {
            repository.getAllBuildings().collect { buildingList ->
                _buildings.value = buildingList
            }
        }
    }

    fun addBuilding(building: BuildingEntity) {
        viewModelScope.launch {
            repository.insertBuilding(building)
        }
    }

    fun deleteBuilding(building: BuildingEntity) {
        viewModelScope.launch {
            repository.deleteBuilding(building)
        }
    }
}
