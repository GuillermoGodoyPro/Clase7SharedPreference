package com.matesdev.clase7sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var buttonSendToLogin : Button
    private lateinit var etEnterName : EditText
    private lateinit var etEnterPassword : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonSendToLogin = findViewById(R.id.btEnviar)
        etEnterName = findViewById(R.id.etUser)
        etEnterPassword = findViewById(R.id.etPasswordReg)


        buttonSendToLogin.setOnClickListener{
            if(etEnterName.text.isNullOrEmpty() && etEnterPassword.text.isNullOrEmpty() ) {
                Toast.makeText(this, "Ingrese user y pass", Toast.LENGTH_SHORT).show()
            }else{

                val userName = etEnterName.text.toString()
                val userPassword = etEnterPassword.text.toString()

                val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
                val editor = preferences.edit()

                editor.putString("name", userName)
                editor.putString("pass", userPassword)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }


        }

    }
}