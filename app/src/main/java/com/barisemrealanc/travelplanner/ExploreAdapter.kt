package com.barisemrealanc.travelplanner

import ExplorePost
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemExplorePostBinding

class ExploreAdapter(private val posts: List<ExplorePost>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val binding = ItemExplorePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    inner class ExploreViewHolder(private val binding: ItemExplorePostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: ExplorePost) {
            binding.profileName.text = post.profileName
            binding.postDate.text = post.postDate
            binding.postDescription.text = post.description
            binding.profileImage.setImageResource(post.profileImage)
            binding.postImage.setImageResource(post.postImage)
        }
    }
}
