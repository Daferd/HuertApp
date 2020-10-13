package com.daferarevalo.hueratapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*

class registroActivity : AppCompatActivity() {

    companion object {
        private const val EMPTY = " "
        private const val SPACE = " "
    }

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val empty = ""
        //val datosRecibidos = intent.extras
        //val numeroEnviado = datosRecibidos?.getInt("numero")
        //Toast.makeText(this, "El numero enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()

        registrar_Button.setOnClickListener {

            val correo = correoEditTextLogin.text.toString()
            val contrasena = contraseñaEditText.text.toString()
            val nombre = nombreEditText.text.toString()
            val repContrasena = repContraseñaEditText.text.toString()
            val ciudadNacimiento = ciudadNacimientoSpinner.selectedItem

            if (nombre == empty || correo == empty || contrasena == empty || repContrasena == empty)
                Toast.makeText(this, R.string.errorCamposVacios, Toast.LENGTH_SHORT).show()
            else if (contrasena.length < 6) {
                Toast.makeText(
                    this,
                    "La contraseña debe ser de mínimo 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (contrasena != repContrasena)
                Toast.makeText(this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            else {
                goToLoginActivity()
            }
            //respuestaTextView.text = resources.getString(R.string.respuesta, nombre, correo, ciudadNacimiento)
        }
    }

    private fun goToLoginActivity() {
        val correo = correoEditTextLogin.text.toString()
        val contrasena = contraseñaEditText.text.toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contrasena", contrasena)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val correo = correoEditTextLogin.text.toString()
        val contrasena = contraseñaEditText.text.toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contrasena", contrasena)
        startActivity(intent)
        finish()
    }
}