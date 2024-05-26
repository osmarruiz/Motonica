package com.example.motonica.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motonica.R
import com.example.motonica.adapter.MotorcycleAdapter
import com.example.motonica.models.Motorcycle

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var motorcycleAdapter: MotorcycleAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Iniciar el adaptador con una lista vacía al principio
        motorcycleAdapter = MotorcycleAdapter(emptyList())
        recyclerView.adapter = motorcycleAdapter

        // Configurar el ViewModel
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Observar los datos del ViewModel
        homeViewModel.motorcycles.observe(viewLifecycleOwner) { motorcycles ->
            motorcycleAdapter = MotorcycleAdapter(motorcycles)
            recyclerView.adapter = motorcycleAdapter
        }
    }
}
