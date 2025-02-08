package com.barisemrealanc.travelplanner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activity_splash.xml dosyasını bağla
        setContentView(R.layout.activity_splash)

        // Gecikme ile yönlendirme işlemi
        Handler(Looper.getMainLooper()).postDelayed({
            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                // Kullanıcı giriş yaptıysa MainActivity'e yönlendir
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Kullanıcı giriş yapmadıysa LoginActivity'e yönlendir
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
            }
            finish() // SplashActivity'yi kapat
        }, 3000) // 3000ms = 3 saniye
    }
}
