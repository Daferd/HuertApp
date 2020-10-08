package com.daferarevalo.hueratapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //oeee
        val datosRegistro = intent.extras
        val emailRegistro = datosRegistro?.getString("correo")
        val passwordRegistro = datosRegistro?.getString("contraseña")

        iniciarSesionButton.setOnClickListener {
            val emailLogin = correoEditTextLogin.text.toString()
            val passwordLogin = contrasenaEditTextLogin.text.toString()

            if (emailLogin.equals("") || passwordLogin.equals("")) {
                Toast.makeText(this, "Alagunos campos están vacios", Toast.LENGTH_LONG).show()
            } else {
                if (emailRegistro == emailLogin && passwordRegistro == passwordLogin) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "El correo o la clave son incorrectos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        registrarButton.setOnClickListener {
            val intent = Intent(this, registroActivity::class.java)
            startActivity(intent)
        }
    }
}