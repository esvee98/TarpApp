package com.example.tarpapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_page.*
import android.Manifest.permission
import android.Manifest.permission.CALL_PHONE
import android.support.v4.app.ActivityCompat
import android.os.Build



class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        sec1.setOnClickListener {
            val intent = Intent(applicationContext, ScrollingActivity::class.java)
            startActivity(intent)
        }
        sec2.setOnClickListener {
            val intent=Intent(applicationContext,ForumMain::class.java)
            startActivity(intent)
        }
        sec5.setOnClickListener {
            val intent = Intent(applicationContext, Feedback::class.java)
            startActivity(intent)
        }
        sec3.setOnClickListener {
            callPhoneNumber()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
            else
            {
                Log.e("Call", "Permission not Granted");
            }
        }
    }

    fun callPhoneNumber() {
        val num = "02227546669"
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling

                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)

                    return
                }

                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + num)
                startActivity(callIntent)

            } else {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + num)
                startActivity(callIntent)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }
}
