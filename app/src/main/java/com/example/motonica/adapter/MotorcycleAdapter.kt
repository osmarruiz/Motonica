package com.example.motonica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motonica.R
import com.example.motonica.models.Motorcycle

class MotorcycleAdapter(
    private var motorcycleList: List<Motorcycle>,
    private val onItemClickListener: (Motorcycle) -> Unit
) : RecyclerView.Adapter<MotorcycleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.motorcycle_list_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return motorcycleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val motorcycle = motorcycleList[position]
        holder.txtBrand.text = motorcycle.brand
        holder.txtPrice.text = "$ ${motorcycle.price}"
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(motorcycle)
        }
    }

    fun updateMotorcycles(newMotorcycleList: List<Motorcycle>) {
        motorcycleList = newMotorcycleList
        notifyDataSetChanged()
    }
}
