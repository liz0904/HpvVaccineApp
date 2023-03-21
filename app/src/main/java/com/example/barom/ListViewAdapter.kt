package com.example.barom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val context: Context,val questList:ArrayList<QuestClass>):BaseAdapter() {
    override fun getCount(): Int {
        return questList.size
    }

    override fun getItem(position: Int): Any {
        return questList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View=LayoutInflater.from(context).inflate(R.layout.quest_listitem,null)

        val titleTextView=view.findViewById<TextView>(R.id.textTitleView)
        val contentTextView=view.findViewById<TextView>(R.id.contentTextView)
        // val resourceId=context.resources.getIdentifier()

        val quest=questList[position]
        titleTextView.text=quest.title
        contentTextView.text=quest.content

        return view
    }

    fun getTitle(position: Int):String{
        return questList[position].title
    }

    fun getContent(position: Int):String{
        return questList[position].content
    }

    fun getDetail(position: Int):String{
        return questList[position].detail
    }
}