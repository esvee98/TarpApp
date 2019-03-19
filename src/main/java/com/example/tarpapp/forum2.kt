package com.example.tarpapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_forum2.*
import android.R.string.cancel
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import kotlinx.android.synthetic.main.reply.view.*
import android.graphics.ColorSpace.Model
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.reply.*
import kotlinx.android.synthetic.main.replyitem.*


class forum2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum2)
        val context= this
        val intent = intent
        val postId = intent.extras!!.getInt("postID")
        //val postId = getIntent().getStringExtra("postID")
        val db=DataBase(context)

        txt.text = db.retrievePost(postId)
        txt.setOnClickListener {

            val mdialogView = LayoutInflater.from(this).inflate(R.layout.reply,null)
            val builder = AlertDialog.Builder(this)
                .setView(mdialogView)
                .setTitle("Reply")
            val mAlertDialog = builder.show()
            mdialogView.dialogReply.setOnClickListener {
                mAlertDialog.dismiss()
                val reply = mdialogView.rep.text.toString()
                db.insertReply(reply,postId)

                finish()
                startActivity(getIntent())
            }
            mdialogView.dialogCancel.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }


        val listview = listView
        val replies = db.retrievePostReplies(postId)
        val listItems = arrayOfNulls<String>(replies!!.size)
// 3
        for (i in 0 until replies.size) {
            val reply = replies[i]
            listItems[i] = reply
        }
        Log.i("replies", listItems.size.toString())

        val adapter = ArrayAdapter(this, R.layout.replyitem, listItems)
        listview.adapter = adapter


//        val listView =ListView(this)
//        val values = arrayListOf<String>(db.retrievePostReplies(postId).toString())
//        val adapter = ArrayAdapter<String>(this,android.R.,values)
    }
}
