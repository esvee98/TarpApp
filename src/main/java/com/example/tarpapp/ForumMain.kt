package com.example.tarpapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_forum_main.*

class ForumMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_main)

        forum_list_recyclerview.layoutManager = LinearLayoutManager(this)
        forum_list_recyclerview.adapter = ForumAdapter(this)
        add_forum.setOnClickListener {
            val intent = Intent(applicationContext, forum3::class.java)
            startActivity(intent)
        }
    }
}
