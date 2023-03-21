package com.example.barom


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//목록 보기
class QuestView: AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var btn_add:Button

    //변수 선언
    lateinit var homeBtn4: Button
    lateinit var hospitalBtn4:Button
    lateinit var infoBtn4:Button
    lateinit var questBtn4:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_listview)

        homeBtn4 = findViewById(R.id.infoBtn4)
        hospitalBtn4 = findViewById(R.id.hospitalBtn4)
        infoBtn4 = findViewById(R.id.infoBtn4)
        questBtn4 = findViewById(R.id.questBtn4)

        homeBtn4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        hospitalBtn4.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        infoBtn4.setOnClickListener {
            val intent = Intent(this, InfoActivity1::class.java)
            startActivity(intent)
        }
        questBtn4.setOnClickListener {
            val intent = Intent(this, QuestView::class.java)
            startActivity(intent)
        }


        var questList= arrayListOf<QuestClass>(
            QuestClass("서바릭스, 가다실 4가, 가다실 9가의 차이는 무엇인가요?",
                "서바릭스와 가다실 4가, 가다실 9가의 차이에 대해 알고 싶으면 이 글을 클릭해주세요!",
                "세 백신 모두 인유두종바이러스(HPV) 예방 백신입니다. \n" +
                        "서바릭스는 두 종류의 바이러스인 고위험형인 16번, 18번 유형의 hpv를 예방합니다.\n" +
                        "가다실 4가는 네 종류의 바이러스인 6, 11, 16, 18번 유형의 hpv를 예방합니다.\n" +
                        "가다실 9가는 아홉 종류의 바이러스인 6, 11, 16, 18, 31, 33, 45, 52, 58번 유형의 바이러스 예방이 가능하며, 가다실 4가에서 추가된 5가지 HPV 유형 관련 질환에 대해 96.7% 예방효과를 보이고 있습니다. \n" +
                        "HPV 백신은 종류에 따라 가격 차이가 있으나 고위험형인 16, 18형은 공통적으로 예방 가능하니 전문의와 상담 후, 본인이 예방하고 싶은 바이러스의 범위에 따라 선택해 접종하면 됩니다.\n"),
            QuestClass("가다실을 남성이 맞아도 효과가 있을까?",
                "HPV 예방 백신은 여자만 맞으면 된다는 인식이 강한데요, 남자가 맞으면 안되는 걸까요? 자세히보려면 이 글을 클릭해주세요!",
                "효과가 있습니다. 가다실 접종 대상에 만 9세~26세 남성이 포함되어 있습니다. 남성도 인유두종바이러스(HPV) 16, 18, 31, 33, 45, 52, 58형에 의한 항문암과 6, 11형에 의한 생식기 사마귀(첨형콘딜로마), 6, 11, 16, 18, 31, 33, 45, 52, 58형에 의한 항문 상피내 종양 예방 효과가 있습니다. 최근에는 두경부암도 HPV와 연관이 깊은 것으로 밝혀지고 있어, 백신을 맞으면 이들 질환을 예방하는 데에 도움이 될 것입니다. \n" +
                        "HPV 감염의 주요 요인은 성접촉으로, 성접촉 이외의 경로로 HPV에 감염되는 경우는 매우 드뭅니다. 또한, HPV에 감염된 사람 대부분은 증상이 없으며, 성인 인구의 70%가 적어도 한 번의 HPV감염을 경험합니다. 백신 접종으로 성접촉에 인해 자신도 모르게 타인에게 바이러스를 전염시키는 것을 예방할 수 있을 것입니다.\n"),
            QuestClass("백신의 효과가 평생 지속적인가?",
                "아닙니다. 인유두종바이러스(HPV) 2가 백신 ‘서바릭스’의 항체 지속기간은 약 50년, HPV 4가, 9가 백신 ‘가다실’의 항체 지속기간은 약 30년으로 알려져 있습니다.",
                "아닙니다. 인유두종바이러스(HPV) 2가 백신 ‘서바릭스’의 항체 지속기간은 약 50년, HPV 4가, 9가 백신 ‘가다실’의 항체 지속기간은 약 30년으로 알려져 있습니다. 또한, 예방가능한 HPV 유형 외의 HPV 고위험 유형에 대한 감염의 위험은 여전히 남아있으므로 HPV 백신 접종 후에도 자궁경부암 선별검사는 정기적으로 받는 것이 좋습니다."),
            QuestClass("성관계를 한 사람에게는 백신의 효과가 없을까?",
                "아닙니다. 성경험으로 인해 특정 유형의 인유두종바이러스(HPV)에 노출되었다 해도, 다른 유형의 HPV 감염으로 인한 질환 예방 효과를 기대할 수 있어 백신을 접종하는 것이 좋습니다. ",
                "아닙니다. 성경험으로 인해 특정 유형의 인유두종바이러스(HPV)에 노출되었다 해도, 다른 유형의 HPV 감염으로 인한 질환 예방 효과를 기대할 수 있어 백신을 접종하는 것이 좋습니다. 하지만, 성경험 전 HPV 백신을 접종 받는 것이 효과가 높을 것으로 기대되며, 이미 성 경험이 있다면 더 낮은 효과를 보일 수도 있습니다. 접종 기간 중 성관계가 금기 사항은 아니지만, 접종기간에는 충분한 면역력이 형성되지 않은 시기이기 때문에 접종기간 중 바이러스에 노출되면 예방효과는 떨어질 수 있습니다."),
            QuestClass("백신이 왜 소수의 기업에서만 생산되고 있는가?",
                "가다실과 같은 프리미엄 백신은 높은 기술적 장벽으로 글로벌 제약사들만 1~2개 제품을 개발해 시장에 내놓은 상태입니다",
                "가다실과 같은 프리미엄 백신은 높은 기술적 장벽으로 글로벌 제약사들만 1~2개 제품을 개발해 시장에 내놓은 상태입니다. 모든 백신은 개발 초기 실험동물을 이용한 실험에서 안전성을 확보한 뒤, 인체를 대상으로 세 차례의 임상시험을 수행합니다. 바이러스 대유행으로 백신 개발이 긴급한 경우 등 특별한 사례를 제외하면, 이 모든 단계를 통과해야만 비로소 백신을 인체에 접종할 수 있습니다. 이러한 어려움 때문에 여러 기업에서 백신을 생산하기 어렵습니다."),
            QuestClass("백신의 가격이 높은 이유와 병원마다 가격이 상이한 이유는 무엇인가?",
                "가다실은 비보험 백신입니다. 그렇기 때문에 접종 병원의 백신 물량, 이익 계산 등에 의해 가격이 결정됩니다.",
                "가다실은 비보험 백신입니다. 그렇기 때문에 접종 병원의 백신 물량, 이익 계산 등에 의해 가격이 결정됩니다. 최근에 한국 MSD측은 \"가다실을 비롯한 백신은 생산고유의 복잡성과 긴 생산기간 및 품질관리 공정을 거쳐야 하므로, 광범위한 인프라 확보 차원에서 R&D 투자 등이 확대돼 가격 인상이 불가피\" 했다고 가격 인상 이유를 밝혔습니다. 접종을 시행해야 하는 병의원은 갑작스러운 백신 공급가격 인상으로 물량 확보를 위한 눈치싸움을 해야 하는데다, 2,3회차 선결제 백신에 대한 차액부담을 지게 됐습니다. "),
            QuestClass("백신을 접종하고 나타나는 부작용은 무엇이 있는가?",
                "백신에 대한 부작용에 대해 걱정이 있다면 게시글을 클릭해 자세한 내용을 확인하세요!",
                "다른 백신과 마찬가지로 접종부위의 통증, 부음, 두드러기 등의 국소반응과 발열, 메스꺼움, 근육통 등과 같은 전신반응이 나타날 수 있습니다. 백신 접종 후 이상반응으로 인해 병원 진료를 받는 경우 예방접종피해 국가보상신청이 가능합니다. \n" +
                        "(단, 진료비 중 본인부담금 30만원 이상의 경우에 한함)\n"),
        )


        listView=findViewById(R.id.listview)
        btn_add=findViewById(R.id.btn_add)

        var questlist=questList
        listView.adapter=ListViewAdapter(this, questlist)
        ListViewAdapter(this,questlist).notifyDataSetChanged()

        //상세내용 확인->QuestItem으로 넘어감
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"자세한 내용 확인", Toast.LENGTH_SHORT).show()
            val intent=Intent(this, QuestItem::class.java)
            intent.putExtra("title", ListViewAdapter(this,questlist).getTitle(position))
            intent.putExtra("content", ListViewAdapter(this,questlist).getContent(position))
            intent.putExtra("detail", ListViewAdapter(this,questlist).getDetail(position))
            startActivity(intent)
        }

        //질문추가 기능->QuestAdd로 넘어감
        btn_add.setOnClickListener {
            Toast.makeText(this,"질문 추가하기", Toast.LENGTH_SHORT).show()
            val intent=Intent(this, QuestAdd::class.java)
            startActivity(intent)
        }

        //QuestAdd에서 넘어온 데이터를 questlist 배열에 추가
        if(intent.hasExtra("title")) {
            questlist.add(
                QuestClass(intent.getStringExtra("title").toString(),
                    intent.getStringExtra("content").toString(),
                    intent.getStringExtra("detail").toString()
                )
            )
            ListViewAdapter(this, questlist).notifyDataSetChanged()
        }

    }
}