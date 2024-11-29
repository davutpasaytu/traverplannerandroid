package com.barisemrealanc.travelplanner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Splash ekranında 3 saniye bekle
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish() // Splash ekranını kapat
        }, 3000)
    }
}
