package com.fahad.astronaut_presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_presentation.databinding.ListItemAstronautBinding

class AstronautListAdapter(
    private var astronautList: MutableList<Astronaut>,
    private val onItemClick: (Astronaut) -> Unit
): RecyclerView.Adapter<AstronautViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstronautViewHolder {
        val binding = ListItemAstronautBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AstronautViewHolder(binding) {
            onItemClick(astronautList[it])
        }
    }

    override fun onBindViewHolder(holder: AstronautViewHolder, position: Int) {
        holder.bind(data = astronautList[position])
    }

    override fun getItemCount(): Int {
        return astronautList.size
    }

    fun updateList(astronautList: List<Astronaut>) {
        this.astronautList.clear()
        this.astronautList.addAll(astronautList)
        notifyDataSetChanged()
    }
}