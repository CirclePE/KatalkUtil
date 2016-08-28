package com.lwh8762.katalkutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

public class MainActivity extends AppCompatActivity {
    private KakaoLink kakaoLink;
    private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            kakaoLink = KakaoLink.getKakaoLink(this);
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

    }

    private void send() {
        try {
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
            kakaoTalkLinkMessageBuilder.addText("지금바로 구매하세요!");
            kakaoTalkLinkMessageBuilder.addImage("http://imgnews.naver.com/image/347/2016/08/18/2016081715335738075_20160817154251_1_99_20160818003106.jpg", 300, 300);
            kakaoTalkLinkMessageBuilder.addWebButton("바로가기", "http://kr.battle.net/heroes/ko/");
            kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(), this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
