package com.arikan.deneme4yapayzeka.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.arikan.deneme4yapayzeka.databinding.ItemBuildingBinding
import com.arikan.deneme4yapayzeka.data.local.entities.BuildingEntity

class BuildingAdapter(
    private val onBuildingClick: (BuildingEntity) -> Unit
) : ListAdapter<BuildingEntity, BuildingAdapter.BuildingViewHolder>(BuildingDiffCallback()) {

    inner class BuildingViewHolder(private val binding: ItemBuildingBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(building: BuildingEntity) {
            binding.buildingName.text = building.name
            binding.root.setOnClickListener { onBuildingClick(building) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingViewHolder {
        val binding = ItemBuildingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BuildingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuildingViewHolder, position: Int) {
        val building = getItem(position)
        holder.bind(building)
    }
}

class BuildingDiffCallback : DiffUtil.ItemCallback<BuildingEntity>() {
    override fun areItemsTheSame(oldItem: BuildingEntity, newItem: BuildingEntity): Boolean {
        return oldItem.id == newItem.id // ID'ler aynı mı?
    }

    override fun areContentsTheSame(oldItem: BuildingEntity, newItem: BuildingEntity): Boolean {
        return oldItem == newItem // İçerikler aynı mı?
    }
}
