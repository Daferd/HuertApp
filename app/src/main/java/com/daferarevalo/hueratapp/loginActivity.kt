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

        val empty = ""
        val datosRegistro = intent.extras
        val emailRegistro = datosRegistro?.getString("correo")
        val passwordRegistro = datosRegistro?.getString("contrasena")


        iniciarSesionButton.setOnClickListener {
            val emailLogin = correoEditTextLogin.text.toString()
            val passwordLogin = contrasenaEditTextLogin.text.toString()

            if (emailLogin == empty || passwordLogin == empty) {
                Toast.makeText(this, "Algunos campos están vacios", Toast.LENGTH_LONG).show()
            } else if (emailLogin != emailRegistro || passwordLogin != passwordRegistro) {
                Toast.makeText(this, "El correo o la clave son incorrectos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                goToMainActivity()
            }
        }

        registrarButton.setOnClickListener {
            val intent = Intent(this, registroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun goToMainActivity() {
        val emailLogin = correoEditTextLogin.text.toString()
        val passwordLogin = contrasenaEditTextLogin.text.toString()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", emailLogin)
        intent.putExtra("password", passwordLogin)
        startActivity(intent)
        finish()
    }
}