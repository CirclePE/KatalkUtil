package com.lwh8762.katalkutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
            kakaoTalkLinkMessageBuilder.addText("TEST");
            kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(),this);
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }

    }
}
