package com.daferarevalo.hueratapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.hueratapp.R
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

        //val datosRecibidos = intent.extras
        //val numeroEnviado = datosRecibidos?.getInt("numero")
        //Toast.makeText(this, "El numero enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()

        registrar_Button.setOnClickListener {

            val correo = correoEditTextLogin.text.toString()
            val contrasena = contraseñaEditText.text.toString()

            val intent = Intent(this, loginActivity::class.java)
            intent.putExtra("correo", correo)
            intent.putExtra("contraseña",contrasena)
            startActivity(intent)
            finish()

            val nombre = nombreEditText.text.toString()
            val repContrasena = repContraseñaEditText.text.toString()

            val ciudadNacimiento = ciudadNacimientoSpinner.selectedItem

            respuestaTextView.text = resources.getString(R.string.respuesta, nombre, correo, ciudadNacimiento)
        }
    }

    //override fun onBackPressed() {
      //  super.onBackPressed()
        //val intent = Intent(this, loginActivity::class.java)
        //startActivity(intent)
       // finish()
    //}
}