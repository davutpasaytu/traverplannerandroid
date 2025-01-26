package com.barisemrealanc.travelplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemSavedBinding

data class SavedItem(
    val title: String,
    val iconRes: Int,
    val subtitle: String
)

class SavedAdapter(private val savedItems: List<SavedItem>) :
    RecyclerView.Adapter<SavedAdapter.SavedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val binding = ItemSavedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        val item = savedItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = savedItems.size

    class SavedViewHolder(private val binding: ItemSavedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SavedItem) {
            binding.textViewTitle.text = item.title
            binding.textViewSubtitle.text = item.subtitle
            binding.imageViewIcon.setImageResource(item.iconRes)
        }
    }
}
