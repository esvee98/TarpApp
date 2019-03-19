package com.example.tarpapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*
import android.content.DialogInterface



class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        sub1.setOnClickListener {
            var a1=ans1.checkedRadioButtonId
            val radio1:RadioButton=findViewById(a1)
            var a2=ans2.checkedRadioButtonId
            val radio2:RadioButton=findViewById(a2)
            var a3=ans3.checkedRadioButtonId
            val radio3:RadioButton=findViewById(a3)
            var a4=ans4.checkedRadioButtonId
            val radio4:RadioButton=findViewById(a4)
            var a5=ans5.checkedRadioButtonId
            val radio5:RadioButton=findViewById(a5)
            var a6=ans6.checkedRadioButtonId
            val radio6:RadioButton=findViewById(a6)
            var a7=ans7.checkedRadioButtonId
            val radio7:RadioButton=findViewById(a7)
            var a8=ans8.checkedRadioButtonId
            val radio8:RadioButton=findViewById(a8)
            var a9=ans9.checkedRadioButtonId
            val radio9:RadioButton=findViewById(a9)
            var a10=ans10.checkedRadioButtonId
            val radio10:RadioButton=findViewById(a10)
            var answer1=radio1.text
            var answer2=radio2.text
            var answer3=radio3.text
            var answer4=radio4.text
            var answer5=radio5.text
            var answer6=radio6.text
            var answer7=radio7.text
            var answer8=radio8.text
            var answer9=radio9.text
            var answer10=radio10.text
            var c=0
            if(answer1=="Some Days")
                c+=5
            else if (answer1=="Most Days")
                c+=30
            else if (answer1=="Almost Every Day")
                c+=80
            if(answer2=="Some Days")
                c+=5
            else if (answer2=="Most Days")
                c+=30
            else if (answer2=="Almost Every Day")
                c+=80
            if(answer3=="Some Days")
                c+=5
            else if (answer3=="Most Days")
                c+=30
            else if (answer3=="Almost Every Day")
                c+=80
            if(answer4=="Some Days")
                c+=5
            else if (answer4=="Most Days")
                c+=30
            else if (answer4=="Almost Every Day")
                c+=80
            if(answer5=="Some Days")
                c+=5
            else if (answer5=="Most Days")
                c+=30
            else if (answer5=="Almost Every Day")
                c+=80
            if(answer6=="Some Days")
                c+=5
            else if (answer6=="Most Days")
                c+=30
            else if (answer6=="Almost Every Day")
                c+=80
            if(answer7=="Some Days")
                c+=10
            else if (answer7=="Most Days")
                c+=50
            else if (answer7=="Almost Every Day")
                c+=80
            if(answer8=="Some Days")
                c+=5
            else if (answer8=="Most Days")
                c+=30
            else if (answer8=="Almost Every Day")
                c+=80
            if(answer9=="Some Days")
                c+=5
            else if (answer9=="Most Days")
                c+=30
            else if (answer9=="Almost Every Day")
                c+=80
            if(answer10=="Some Days")
                c+=50
            else if (answer10=="Most Days")
                c+=100
            else if (answer10=="Almost Every Day")
                c+=100
            val builder = AlertDialog.Builder(this)
            when(c) {
                in 0..80 -> builder.setMessage("Take a deep breath. You're not alone. It doesn't seem like you have a serious form of depression. But, talk to someone when you're feeling down ")
                in 81..150 -> builder.setMessage("You possibly have a moderate form of depression. The best course of action is to speak to a counselor or doctor. However, you could also wait a few days and take the test again. Meanwhile make sure you're getting enough physical activity, eating healthy and getting enough sleep. Don't forget that you're not alone and reaching out can bring about miracles.")
                else -> builder.setMessage("The things that happen around you are not your fault. There are people there for you and all you need to do is reach out. Go seek an appointment with a counsellor or doctor immediately. Your life is worth more than this misery and you need to take help to come out of this.")
            }
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, id ->
                    //do things
                }
            val alert = builder.create()
            alert.show()
        }
    }
}
