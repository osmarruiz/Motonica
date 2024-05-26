package com.example.motonica.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.motonica.models.Motorcycle
import com.example.motonica.network.RetrofitInstance
import android.util.Log

class HomeViewModel : ViewModel() {

    private val _motorcycles = MutableLiveData<List<Motorcycle>>()
    val motorcycles: LiveData<List<Motorcycle>> get() = _motorcycles

    init {
        fetchMotorcycles()
    }

    private fun fetchMotorcycles() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.motorcycleService.getMotorcycles() // Obtener todas las motocicletas
                if (response.isSuccessful) {
                    val motorcycles = response.body()
                    motorcycles?.let {
                        _motorcycles.value = it // Asignar la lista de motocicletas
                    }
                } else {
                    Log.e("HomeViewModel", "Error en la respuesta de la API")
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Excepción al hacer la petición", e)
            }
        }
    }

}
