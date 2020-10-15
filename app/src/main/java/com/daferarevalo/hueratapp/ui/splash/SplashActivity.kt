package com.daferarevalo.hueratapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.hueratapp.R
import com.daferarevalo.hueratapp.ui.login.loginActivity
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