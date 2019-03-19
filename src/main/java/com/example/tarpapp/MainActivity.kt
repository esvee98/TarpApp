package com.example.tarpapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            val usrname = username.text.toString();
            val passwd = pswd.text.toString();

            val db = DataBase(this)
            val origPswd = db.readUserPassword(usrname)

            if (origPswd != null && (passwd == origPswd)) {
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainPage::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
        }
        sign.setOnClickListener {
            val intent=Intent(applicationContext,signup::class.java)
            startActivity(intent)
        }
    }
}
