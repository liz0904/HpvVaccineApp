package com.example.barom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class InfoActivity1 : AppCompatActivity() {

    lateinit var listView: ExpandableListView

    //변수 선언
    lateinit var homeBtn3: Button
    lateinit var hospitalBtn3: Button
    lateinit var imfoBtn3: Button
    lateinit var quest3: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2)

        val newDisplay = windowManager.defaultDisplay
        val width = newDisplay.width

        homeBtn3 = findViewById(R.id.homeBtn4)
        hospitalBtn3 = findViewById(R.id.hospitalBtn4)
        imfoBtn3 = findViewById(R.id.infoBtn4)
        quest3 = findViewById(R.id.questBtn4)

        homeBtn3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn3.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        imfoBtn3.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        quest3.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }

        val DataList = ArrayList<myGroup>()
        listView = findViewById<View>(R.id.mylist) as ExpandableListView
        var temp = myGroup("HPV란?")
        temp.child.add("HPV란 인유두종 바이러스로 불리는 HPV는 성 접촉을 통해 감염되는 바이러스 중 하나입니다. 모든 연령의 남녀에서 HPV 감염이 가능하며, HPV에 감염된 사람 대부분은 증상이 없기 때문에 본인이 감염되었다는 사실을 모른채 다른 사람에게 HPV를 전염시킬 수 있습니다.")
        DataList.add(temp)
        temp = myGroup("HPV의 위험성")
        temp.child.add("대부분의 경우 인체에에 감염된 인유두종 바이러스는 면역체계에 의해 제거되지만 지속적으로 고위험군의 HPV에 감염되면 자궁경부암으로 이어질 가능성이 매우 높습니다.")
        DataList.add(temp)
        temp = myGroup("HPV 백신이란?")
        temp.child.add("가다실®은 HPV*감염에 의한 자궁경부암, 외음부암, 질암(여성 해당), 항문암 및 생식기 사마귀 등을 예방할 수 있으며, 성별 관계 없이 남녀 모두 접종할 수 있는 HPV 백신입니다. \n가다실®은만 9-26세 남녀 모두 접종 가능한 국내 유일 4가 HPV 백신이며, 10년 이상 장기 임상 연구를 통해 지속적인 예방 효과를 입증하였습니다. ")
        DataList.add(temp)
        temp = myGroup("HPV 백신의 종류")
        temp.child.add("국내 시판 중인 HPV 백신은 서바릭스, 가다실 4가, 가다실 9가가 있습니다. 서바릭스는 고위험형인 16, 18번 유형의 HPV만 예방하며 항체 지속 기간은 최대 50년입니다. \n가다실 4가는 네 종류 바이러스 예방이 가능하며, 가다실 9가는 국내 유일의 9가 hpv 백신으로 아홉종류의 바이러스 예방이 가능하며 추가된 5가지 HPV 유형 관련 질환에 대해 96.7% 예방 효과를 보입니다.")
        DataList.add(temp)
        temp = myGroup("HPV 백신의 접종은 어떻게 하나요?")
        temp.child.add("만 9~13세 여아 및 남아의 경우, 최초 접종을 하고 6개월 이후 2차 접종을 진행합니다. \n만 9~26세 여아 및 남아의 경우 3회 접종으로, 최초 접종 2개월 이후 2차 접종을 진행하고,  4개월 이후 3차 접종을 합니다.")
        DataList.add(temp)
        temp = myGroup("접종 시기를 놓쳤을 경우 어떻게 해야하나요?")
        temp.child.add("처음 백신을 맞을 때는 사람에 따라 크고 작은 이상반응이 나타날 수 있습니다. 근육에 접종하는 자궁경부암 백신 특성 상 발열이나 접종 부위 통증이 대부분입니다. \n자궁경부암 백신은 가까운 산부인과·가정의학과·내과 등에서 접종할 수 있습니다. 6개월에 걸쳐 2~3차례 맞습니다. 만일 접종시기를 놓쳤다면 가능한 빨라 나머지 접종을 마쳐야 합니다. \n현재 백신을 서로 섞어서 접종하는 교차접종에 대한 연구결과는 없습니다. 따라서 처음 접종한 백신이 무엇인지를 기억했다가 같은 백신으로 접종해야 예방효과를 극대화 할 수 있습니다.")
        DataList.add(temp)

        val adapter =
            ExpandAdapter(applicationContext, R.layout.group_row, R.layout.child_row, DataList)
        listView.setIndicatorBounds(width - 50, width) //이 코드를 지우면 화살표 위치가 바뀐다.

        listView.setAdapter(adapter)
    }
}