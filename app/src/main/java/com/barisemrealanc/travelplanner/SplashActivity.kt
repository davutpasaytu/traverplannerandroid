package com.barisemrealanc.travelplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Giriş Durumunu Kontrol Et
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // Kullanıcı giriş yaptıysa MainActivity'e yönlendir
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Kullanıcı giriş yapmadıysa LoginActivity'e yönlendir
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
