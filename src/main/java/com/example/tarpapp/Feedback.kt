package com.example.tarpapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_feedback.*
import kotlinx.android.synthetic.main.replyitem.*
import java.lang.Exception
import javax.security.auth.Subject

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        sub_feed.setOnClickListener {

            val recepient="shweta.brightstar.98@gmail.com"
            val subject="Feedback"
            val message= msg.text.toString().trim()

            sendEmail (recepient,subject,message)
        }
    }

    private fun sendEmail(recepient:String,subject: String,message:String){

        val intent= Intent(Intent.ACTION_SEND)
        intent.data= Uri.parse("mailto:")
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL,recepient)
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.putExtra(Intent.EXTRA_TEXT,message)

        try {
            startActivity(Intent.createChooser(intent,"choose E-mail client"))
        }
        catch (e: Exception){

            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}
