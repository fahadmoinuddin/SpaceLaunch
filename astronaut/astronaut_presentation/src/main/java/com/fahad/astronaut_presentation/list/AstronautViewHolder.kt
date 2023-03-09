package com.fahad.astronaut_presentation.list

import androidx.recyclerview.widget.RecyclerView
import com.fahad.astronaut_domain.model.Astronaut
import com.fahad.astronaut_presentation.databinding.ListItemAstronautBinding
import com.fahad.core.extension.loadFromUrl

class AstronautViewHolder(
    private val binding: ListItemAstronautBinding,
    private val onItemClick: (Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(data: Astronaut) {
        binding.apply {
            profileImageView.apply {
                transitionName = data.profileImageThumbnail
                loadFromUrl(data.profileImageThumbnail)
            }
            astronautNameTextView.text = data.name
            astronautNationalityTextView.text = data.nationality
        }
    }

}