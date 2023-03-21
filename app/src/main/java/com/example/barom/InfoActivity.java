package com.example.barom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private ExpandableListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        Button info_homeBtn = (Button) findViewById(R.id.homeBtn4);
        Button info_hospitalBtn = (Button)findViewById(R.id.hospitalBtn4);
        Button info_imfoBtn = (Button)findViewById(R.id.infoBtn4);
        Button info_questBtn = (Button)findViewById(R.id.questBtn4);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        listView = (ExpandableListView)findViewById(R.id.mylist);
        myGroup temp = new myGroup("HPV 백신이란?");
        temp.child.add("가다실®은 HPV*감염에 의한 자궁경부암, 외음부암, 질암(여성 해당), 항문암 및 생식기 사마귀 등을 예방할 수 있으며, 성별 관계 없이 남녀 모두 접종할 수 있는 HPV 백신입니다. \n가다실®은만 9-26세 남녀 모두 접종 가능한 국내 유일 4가 HPV 백신이며, 10년 이상 장기 임상 연구를 통해 지속적인 예방 효과를 입증하였습니다. ");
        DataList.add(temp);
        temp = new myGroup("언제 접종하는 것이 맞는가?");
        temp.child.add("내가 어찌 아오");
        DataList.add(temp);
        temp = new myGroup("오늘부터 시작");
        temp.child.add("뭐를?");
        DataList.add(temp);

        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(),R.layout.group_row,R.layout.child_row,DataList);
        listView.setIndicatorBounds(width-50, width); //이 코드를 지우면 화살표 위치가 바뀐다.
        listView.setAdapter(adapter);



        info_homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        info_hospitalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
        info_imfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                startActivity(intent);
            }
        });
        info_questBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QuestView.class);
                startActivity(intent);
            }
        });
    }
}