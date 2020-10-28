package com.daferarevalo.hueratapp.ui.registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.hueratapp.R
import com.daferarevalo.hueratapp.ui.login.loginActivity
import kotlinx.android.synthetic.main.activity_registro.*

class registroActivity : AppCompatActivity() {


    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //val datosRecibidos = intent.extras
        //val numeroEnviado = datosRecibidos?.getInt("numero")
        //Toast.makeText(this, "El numero enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()

        registrar_Button.setOnClickListener {

            val correo = correo_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val nombre = nombre_edit_text.text.toString()
            val repContrasena = repcontrasena_edit_text.text.toString()
            val ubicacion = ubicacionSpinner.selectedItem

            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || repContrasena.isEmpty())
                Toast.makeText(this, R.string.errorCamposVacios, Toast.LENGTH_SHORT).show()
            else if (contrasena.length < 6) {
                Toast.makeText(
                    this,
                    "La contraseña debe contener mínimo 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (contrasena != repContrasena)
                Toast.makeText(this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            else {
                goToLoginActivity()
            }
        }
    }

    private fun goToLoginActivity() {
        val correo = correo_edit_text.text.toString()
        val contrasena = contrasena_edit_text.text.toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contrasena", contrasena)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val correo = correo_edit_text.text.toString()
        val contrasena = contrasena_edit_text.text.toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contrasena", contrasena)
        startActivity(intent)
        finish()
    }
}