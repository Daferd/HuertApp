package com.daferarevalo.hueratapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.hueratapp.R
import com.daferarevalo.hueratapp.ui.drawer.DrawerActivity
import com.daferarevalo.hueratapp.ui.registro.registroActivity
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
            val emailLogin = correo_edit_text_login.text.toString()
            val passwordLogin = contrasena_edit_text_login.text.toString()

            if (emailLogin == empty || passwordLogin == empty) {
                Toast.makeText(this, "Algunos campos están vacios", Toast.LENGTH_LONG).show()
            } else if (emailLogin != emailRegistro || passwordLogin != passwordRegistro) {
                Toast.makeText(this, "El correo o la clave son incorrectos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                goToDrawerActivity()
            }
        }

        registrarButton.setOnClickListener {
            goToRegistroActivity()
        }
    }

    private fun goToDrawerActivity() {
        val emailLogin = correo_edit_text_login.text.toString()
        val passwordLogin = contrasena_edit_text_login.text.toString()
        val intent = Intent(this, DrawerActivity::class.java)
        intent.putExtra("email", emailLogin)
        intent.putExtra("password", passwordLogin)
        startActivity(intent)
        finish()
    }

    private fun goToRegistroActivity() {
        val intent = Intent(this, registroActivity::class.java)
        startActivity(intent)
        finish()
    }
}