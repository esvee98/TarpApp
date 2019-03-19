package com.example.tarpapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forum3.*

class forum3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum3)

        forum_submit.setOnClickListener {
            val post = forum_text.text.toString()

            val db = DataBase(this)
            db.insertPost(post)

            val intent = Intent(applicationContext, ForumMain::class.java)
            startActivity(intent)
            finish()
        }
    }
}
