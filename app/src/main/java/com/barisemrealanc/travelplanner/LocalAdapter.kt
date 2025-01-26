package com.barisemrealanc.travelplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemLocalPostBinding

class LocalAdapter(private val posts: List<LocalPost>) :
    RecyclerView.Adapter<LocalAdapter.LocalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        val binding = ItemLocalPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    inner class LocalViewHolder(private val binding: ItemLocalPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: LocalPost) {
            binding.profileName.text = post.profileName
            binding.postDate.text = post.postDate
            binding.postDescription.text = post.description
            binding.location.text = post.location
            binding.length.text = post.length
            binding.elevationGain.text = post.elevationGain
            binding.time.text = post.time
            binding.profileImage.setImageResource(post.profileImage)
            binding.postImage.setImageResource(post.postImage)
        }
    }
}
