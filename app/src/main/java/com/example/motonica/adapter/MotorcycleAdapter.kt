package com.example.motonica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motonica.models.Motorcycle
import com.example.motonica.R

class MotorcycleAdapter(private var motorcycleList: List<Motorcycle>) : RecyclerView.Adapter<MotorcycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
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
        holder.txtBrand.text = motorcycle.brand
        holder.txtPrice.text = "$ ${motorcycle.price}"
    }

    fun updateMotorcycles(newMotorcycleList: List<Motorcycle>) {
        motorcycleList = newMotorcycleList
        notifyDataSetChanged()
    }
}
