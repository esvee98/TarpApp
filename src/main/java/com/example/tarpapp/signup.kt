package com.example.tarpapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val context=this

        signUp.setOnClickListener{

            if(name.text.isNotEmpty() && reg.text.isNotEmpty() && pwd1.text.isNotEmpty() && pwd2.text.isNotEmpty()){

                if (pwd1.text.toString()==pwd2.text.toString()){

                    var stud=student(name.text.toString(),reg.text.toString(),pwd1.text.toString())
                    var db=DataBase(context)
                    var suc = db.insertUser(stud)
                    if (suc) {
                        Toast.makeText(context,"Success!!!",Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                    Toast.makeText(context,"Password does not match",Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context,"Please fill all the fields",Toast.LENGTH_SHORT).show()
        }
    }
}
