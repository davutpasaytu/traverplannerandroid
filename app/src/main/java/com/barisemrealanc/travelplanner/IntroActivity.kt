package com.barisemrealanc.travelplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.barisemrealanc.travelplanner.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewPager2 setup
        val introPages = listOf(
            IntroPage("Welcome to Travel Planner", "Plan your trips effortlessly", R.drawable.app_logo),
            IntroPage("Discover Places", "Find amazing destinations", R.drawable.app_logo),
            IntroPage("Save & Share", "Share your experiences", R.drawable.app_logo)
        )
        val adapter = IntroAdapter(introPages)
        binding.viewPager.adapter = adapter

        // Button setup
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < introPages.size) {
                binding.viewPager.currentItem += 1
            } else {
                navigateToHome()
            }
        }

        // Skip button
        binding.btnSkip.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val transaction = supportFragmentManager.beginTransaction()
        val homeFragment = HomeFragment()  // HomeFragment'ı burada oluşturuyoruz
        transaction.replace(R.id.firstFragment, homeFragment)  // fragment_container container view ID'si
        transaction.addToBackStack(null)  // Eğer geri tuşu ile fragment'ı geri almak istiyorsanız
        transaction.commit()
    }

}
