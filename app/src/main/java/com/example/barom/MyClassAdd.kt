package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyClassAdd:AppCompatActivity() {
    lateinit var myNameTextView:TextView
    lateinit var myBirthTextView: TextView
    lateinit var myHospitalTextView: TextView
    lateinit var myAddBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myclass_activity)

        myNameTextView=findViewById(R.id.myNameText)
        myBirthTextView=findViewById(R.id.myBirthText)
        myHospitalTextView=findViewById(R.id.myHospitalText)
        myAddBtn=findViewById(R.id.myAddBtn)

        myAddBtn.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            intent.putExtra("name", myNameTextView.text.toString())
            intent.putExtra("birth", myBirthTextView.text.toString())
            intent.putExtra("hospital", myHospitalTextView.text.toString())
            startActivity(intent)
        }
    }
}