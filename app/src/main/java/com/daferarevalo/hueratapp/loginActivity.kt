package com.daferarevalo.hueratapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daferarevalo.hueratapp.registroActivity
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailRegistro = intent.extras
        val emaila = emailRegistro?.getString("correo")
        val passworda = emailRegistro?.getString("contraseña")

        registerButton.setOnClickListener {
            val email = correoEditTextLogin.text.toString()
            val password = contrasenaEditTextLogin.text.toString()

            if(emaila == email && passworda == password){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent=Intent(this, registroActivity::class.java)
                intent.putExtra("correo",email)
                intent.putExtra("contraseña",password)
                startActivity(intent)
            }
        }
    }
}