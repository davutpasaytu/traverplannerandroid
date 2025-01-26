package com.barisemrealanc.travelplanner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.barisemrealanc.travelplanner.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        setupProfile()

        binding.btnLogout.setOnClickListener {
            logout()
        }

        return binding.root
    }

    private fun setupProfile() {
        val user = auth.currentUser
        if (user != null) {
            binding.textViewUserName.text = user.displayName ?: "User Name"
            binding.textViewUserLocation.text = "Wallingford, CT" // Statik olarak ayarlanmış
            binding.textViewFollowers.text = "12"
            binding.textViewFollowing.text = "34"
        } else {
            Toast.makeText(requireContext(), "User not logged in!", Toast.LENGTH_SHORT).show()
        }
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
