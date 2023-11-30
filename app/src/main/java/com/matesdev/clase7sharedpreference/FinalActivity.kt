package com.matesdev.clase7sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FinalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        // Obtener instancia de SharedPreferences
        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)

        // Crear un editor para realizar cambios
        val editor = preferences.edit()

        // Eliminar el valor asociado a la clave "name"
        editor.remove("name")

        // Aplicar los cambios
        editor.apply()
    }
}