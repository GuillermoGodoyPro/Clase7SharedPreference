package com.matesdev.clase7sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btToAction: Button
    private lateinit var textName: TextView
    private lateinit var etUserLogin: EditText
    private lateinit var etPassLogin: EditText
    private lateinit var imgView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToAction = findViewById(R.id.btContinuar)
        textName = findViewById(R.id.tvNombre)
        etUserLogin = findViewById(R.id.etNameLogin)
        etPassLogin = findViewById(R.id.etPasword)
        imgView = findViewById(R.id.imgMain)


        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        val userNameRef = preferences.getString("name", "")
        val passwordRef = preferences.getString("pass", "")


        if (userNameRef != null && passwordRef != null) {
            if(userNameRef.isEmpty()){
                btToAction.text = "registrar"

                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

            }

            btToAction.setOnClickListener{
                val intent = Intent(this, FinalActivity::class.java)


                if( etUserLogin.text.isNullOrEmpty() && etPassLogin.text.isNullOrEmpty() ){
                    Toast.makeText(this, "Ingrese user y pass", Toast.LENGTH_SHORT).show()
                }else{
                    val userName = etUserLogin.text.toString()
                    val passworUser = etPassLogin.text.toString()

                    if( userName == userNameRef && passworUser == passwordRef) {
                        textName.text = userName
                        textName.visibility = View.VISIBLE
                        btToAction.text = "continuar"

                        startActivity(intent)


                    } else {
                        Toast.makeText(this, "usuario o pass invalidos", Toast.LENGTH_SHORT).show()
                    }

                }
            }



        }
    }


}