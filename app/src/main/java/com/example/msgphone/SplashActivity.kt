package com.example.msgphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this,PortalActivity::class.java)

        val cdt = object: CountDownTimer(1000 * 2,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                startActivity(intent)
            }

        }

        cdt.start()
    }
}