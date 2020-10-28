package com.daferarevalo.hueratapp.ui.drawer

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.daferarevalo.hueratapp.R
import com.daferarevalo.hueratapp.ui.login.loginActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.fragment_clases.*

class DrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_clases, R.id.nav_bprp, R.id.nav_biblioisasis, R.id.nav_bibliomundo
            ), drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer, menu)

        val datosLogin = intent.extras
        val correoLogin = datosLogin?.getString("email").toString()
        correoTextView.text = correoLogin

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_cerrar_sesion -> {
                goToLoginActivity()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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

        val correo = correo_edit_text.text.toString()
        val contrasena = contrasena_edit_text.text.toString()

        val intent = Intent(this, loginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contrasena", contrasena)
        startActivity(intent)
        finish()
    }
}