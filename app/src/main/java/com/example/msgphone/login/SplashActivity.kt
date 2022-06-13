package com.example.msgphone.login

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.msgphone.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this, LoginActivity::class.java)

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