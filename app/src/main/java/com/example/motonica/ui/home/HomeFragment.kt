package com.example.motonica.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motonica.DetailsActivity
import com.example.motonica.R
import com.example.motonica.adapter.MotorcycleAdapter


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
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        motorcycleAdapter = MotorcycleAdapter(emptyList()){ selectedMotorcycle ->
            val intent = Intent(requireContext(), DetailsActivity::class.java).apply {

                putExtra("price", selectedMotorcycle.price.toString())
                putExtra("mileage", selectedMotorcycle.mileage.toString())
                putExtra("year", selectedMotorcycle.year.toString())
                putExtra("brand", selectedMotorcycle.brand)
                putExtra("model", selectedMotorcycle.model)
                putExtra("engine", selectedMotorcycle.engine)
                putExtra("color", selectedMotorcycle.color)
                putExtra("location", selectedMotorcycle.location)
                putExtra("description", selectedMotorcycle.description)
            }
            startActivity(intent)
        }
        recyclerView.adapter = motorcycleAdapter
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.motorcycles.observe(viewLifecycleOwner) { motorcycles ->
            motorcycles?.let {
                motorcycleAdapter.updateMotorcycles(it)
            }
        }

    }
}
