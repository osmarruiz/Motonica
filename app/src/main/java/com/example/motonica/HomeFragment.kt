package com.example.motonica

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.motonica.network.RetrofitInstance
import kotlinx.coroutines.launch


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Hacer la petición a la API
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getUser(1)
                if (response.isSuccessful) {
                    val user = response.body()
                    // Actualizar UI con los datos del usuario
                    user?.let {
                        view.findViewById<TextView>(R.id.first_name).text = it.first_name
                        view.findViewById<TextView>(R.id.email).text = it.email
                    }
                } else {
                    Log.e("UserFragment", "Error en la respuesta de la API")
                }
            } catch (e: Exception) {
                Log.e("UserFragment", "Excepción al hacer la petición", e)
            }
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}