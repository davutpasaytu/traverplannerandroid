package com.barisemrealanc.travelplanner

import IntroAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
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
            IntroPage(
                "Welcome to Travel Planner",
                "Plan your trips effortlessly",
                R.drawable.app_logo,
                resources.getColor(R.color.intro1, theme) // Sayfa 1 rengi
            ),
            IntroPage(
                "Discover Places",
                "Find amazing destinations",
                R.drawable.app_logo,
                resources.getColor(R.color.intro2, theme) // Sayfa 2 rengi
            ),
            IntroPage(
                "Save & Share",
                "Share your experiences",
                R.drawable.image3,
                resources.getColor(R.color.intro3, theme) // Sayfa 3 rengi
            )
        )
        val adapter = IntroAdapter(introPages)
        binding.viewPager.adapter = adapter

        // Sayfa göstergesini kur
        setupPageIndicator(introPages.size)

        // Sayfa değişim dinleyicisi
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updatePageIndicator(position)
            }
        })

        // "Next" butonu
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < introPages.size) {
                binding.viewPager.currentItem += 1
            } else {
                navigateToHome()
            }
        }

        // "Skip" butonu
        binding.btnSkip.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // IntroActivity'yi geri tuşundan kaldırmak için
    }

    // Dinamik sayfa göstergesi (dots indicator) kurulum
    private fun setupPageIndicator(pageCount: Int) {
        val indicators = arrayOfNulls<ImageView>(pageCount)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(this).apply {
                setImageResource(R.drawable.indicator_inactive) // Pasif nokta
                this.layoutParams = layoutParams
            }
            binding.pageIndicator.addView(indicators[i])
        }

        // İlk sayfa aktif göstergesi
        updatePageIndicator(0)
    }

    // Sayfa göstergesini güncelle
    private fun updatePageIndicator(position: Int) {
        for (i in 0 until binding.pageIndicator.childCount) {
            val imageView = binding.pageIndicator.getChildAt(i) as ImageView
            imageView.setImageResource(
                if (i == position) R.drawable.indicator_active else R.drawable.indicator_inactive
            )
        }
    }
}
