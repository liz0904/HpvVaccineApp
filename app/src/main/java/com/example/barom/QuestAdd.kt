package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//질문 추가하기
class QuestAdd:AppCompatActivity() {

    lateinit var titleAdd: TextView
    lateinit var contentAdd: TextView
    lateinit var detailAdd: TextView
    lateinit var submitBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_add)

        titleAdd=findViewById(R.id.titleAdd)
        contentAdd=findViewById(R.id.contentAdd)
        detailAdd=findViewById(R.id.contentAdd)
        submitBtn=findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            val intent=Intent(this, QuestView::class.java)
            intent.putExtra("title", titleAdd.text.toString())
            intent.putExtra("content", contentAdd.text.toString())
            intent.putExtra("detail", detailAdd.text.toString())
            startActivity(intent)
        }

    }
}