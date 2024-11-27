package com.arikan.deneme4yapayzeka.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arikan.deneme4yapayzeka.databinding.FragmentBuildingBinding
import com.arikan.deneme4yapayzeka.ui.adapters.BuildingAdapter

class BuildingFragment : Fragment() {

    private var _binding: FragmentBuildingBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BuildingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BuildingAdapter { building ->
            // Binaya tıklandığında yapılacak işlemler
        }

        binding.recyclerViewBuildings.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBuildings.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
