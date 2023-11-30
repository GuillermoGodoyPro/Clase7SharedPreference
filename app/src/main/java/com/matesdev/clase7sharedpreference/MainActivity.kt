package com.matesdev.clase7sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btToRegister: Button
    private lateinit var textName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToRegister = findViewById(R.id.btContinuar)
        textName = findViewById(R.id.tvNombre)

        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        val userName = preferences.getString("name", "")

        if (userName != null) {
            if(userName.isEmpty()){
                btToRegister.text = "registrar"
                btToRegister.setOnClickListener{
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
            } else {
                btToRegister.text = "continuar"
                textName.text = userName
            }
        }
    }
}