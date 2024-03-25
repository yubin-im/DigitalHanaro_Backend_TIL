package com.study.ex03autowired;

import org.springframework.stereotype.Component;

@Component("kakaoCard")
public class KakaoCard implements ICard{
    @Override
    public void buy(String itemName) {
        System.out.println("kakao 카드로 " + itemName + "을 샀다.");
    }
}
