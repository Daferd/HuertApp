package com.daferarevalo.hueratapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private var correoLogin = ""
    //private var passwordLogin = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datosLogin = intent.extras
        val correoLogin = datosLogin?.getString("email").toString()

        activityMainTextView.text = correoLogin
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_cerrar -> {
                goToLoginActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToLoginActivity() {
        val datosLogin = intent.extras
        val correoLogin = datosLogin?.getString("email").toString()
        val passwordLogin = datosLogin?.getString("password").toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correoLogin)
        intent.putExtra("contrasena", passwordLogin)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        goToLoginActivity()
        
    }
}