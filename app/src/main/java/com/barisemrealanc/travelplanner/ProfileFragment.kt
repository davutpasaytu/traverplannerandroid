package com.barisemrealanc.travelplanner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.barisemrealanc.travelplanner.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupProfile()
        setupTabs()
        
        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun setupProfile() {
        val user = auth.currentUser
        if (user != null) {
            binding.textViewUserName.text = user.displayName ?: "User Name"
            binding.textViewUserLocation.text = "Wallingford, CT"
            binding.textViewFollowers.text = "12"
            binding.textViewFollowing.text = "34"
        } else {
            Toast.makeText(requireContext(), "User not logged in!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupTabs() {
        // ViewPager2 için adapter ayarla
        binding.viewPager.adapter = ProfilePagerAdapter(this)

        // TabLayout ile ViewPager2'yi bağla
        TabLayoutMediator(binding.profileTabs, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Feed"
                1 -> "Photos"
                2 -> "Reviews"
                3 -> "Activities"
                else -> null
            }
        }.attach()

        // Set initial tab
        binding.viewPager.setCurrentItem(0, false)
    }

    private fun logout() {
        auth.signOut()
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ProfilePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // Toplam sekme sayısı

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedFragment()
            1 -> PhotosFragment()
            2 -> ReviewsFragment()
            3 -> ActivitiesFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}

class ActivitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activities, container, false)
    }

}

class ReviewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

}

class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }
}


class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }
}

