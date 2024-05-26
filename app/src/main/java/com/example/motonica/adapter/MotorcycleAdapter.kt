package com.example.motonica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.motonica.models.Motorcycle
import com.example.motonica.R

class MotorcycleAdapter(private var motorcycleList: List<Motorcycle>) : RecyclerView.Adapter<MotorcycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // Aquí puedes inicializar las vistas de tu layout
        // Ejemplo: val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.motorcycle_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return motorcycleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val motorcycle = motorcycleList[position]
        // Aquí puedes vincular los datos de tu objeto motorcycle a las vistas
        // Ejemplo: holder.textView.text = motorcycle.name
    }

    fun updateMotorcycles(newMotorcycleList: List<Motorcycle>) {
        motorcycleList = newMotorcycleList
        notifyDataSetChanged()
    }
}
