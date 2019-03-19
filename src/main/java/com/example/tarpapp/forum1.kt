package com.example.tarpapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forum1.*
import kotlinx.android.synthetic.main.content_forum1.*

class forum1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum1)

        txtTitle1.setOnClickListener {

            val intent=Intent(applicationContext,forum2::class.java)
            startActivity(intent)
        }

        add.setOnClickListener {

            val intent=Intent(applicationContext,forum3::class.java)
            startActivity(intent)
        }
    }
}
