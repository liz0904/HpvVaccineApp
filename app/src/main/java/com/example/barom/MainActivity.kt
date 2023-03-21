package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //변수 선언
    var myclass=MyClass("이름을 등록해주세요", "생년월일을 등록해주세요", "병원을 등록해주세요")

    lateinit var nameTextView: TextView
    lateinit var birthTextView: TextView
    lateinit var hospitalTextView: TextView
    lateinit var addBtn:Button

    lateinit var homeBtn: Button
    lateinit var hospitalBtn:Button
    lateinit var infoBtn:Button
    lateinit var questBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView=findViewById(R.id.nameTextView)
        birthTextView=findViewById(R.id.birthTextView)
        hospitalTextView=findViewById(R.id.hospitalTextView)
        addBtn=findViewById(R.id.addBtn)

        homeBtn = findViewById(R.id.homeBtn4)
        hospitalBtn = findViewById(R.id.hospitalBtn4)
        infoBtn = findViewById(R.id.infoBtn4)
        questBtn = findViewById(R.id.questBtn4)

        if (intent.hasExtra("name")){
            myclass= MyClass(intent.getStringExtra("name").toString(),
                intent.getStringExtra("birth").toString(),
                intent.getStringExtra("hospital").toString(),)
        }

        //사용자 정보 등록
        addBtn.setOnClickListener {
            var intent= Intent(this, MyClassAdd::class.java)
            startActivity(intent)
        }

        //사용자 정보 출력
        nameTextView.text=myclass.name
        birthTextView.text=myclass.birth
        hospitalTextView.text=myclass.hospitbal


        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        infoBtn.setOnClickListener {
            val intent = Intent(this, InfoActivity1::class.java)
            startActivity(intent)
        }
        questBtn.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }
    }
}