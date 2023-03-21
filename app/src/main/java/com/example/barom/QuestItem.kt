package com.example.barom

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//자세한 내용 보기
class QuestItem:AppCompatActivity() {

    lateinit var title_detail:TextView
    lateinit var content_detail: TextView
    lateinit var detail_detail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_detail)

        title_detail=findViewById(R.id.title_detail)
        content_detail=findViewById(R.id.content_detail)
        detail_detail=findViewById(R.id.detail_detail)

        title_detail.text=intent.getStringExtra("title")
        content_detail.text=intent.getStringExtra("content")
        detail_detail.text=intent.getStringExtra("detail")

    }
}