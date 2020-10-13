package com.daferarevalo.hueratapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timerTask

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer= Timer()
        timer.schedule(
            timerTask {
                goToLoginActivity()
            }, 1000
        )

    }

    fun goToLoginActivity(){
        val intent=Intent(this, loginActivity::class.java)
        startActivity(intent)
        finish()
    }

}