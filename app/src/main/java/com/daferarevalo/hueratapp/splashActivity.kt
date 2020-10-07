package com.daferarevalo.hueratapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
             }, 2000
        )

    }

    fun goToLoginActivity(){
        val intent=Intent(this, loginActivity::class.java)
        startActivity(intent)
        finish()
    }

}