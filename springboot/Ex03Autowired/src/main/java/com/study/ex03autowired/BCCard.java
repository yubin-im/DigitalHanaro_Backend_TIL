package com.study.ex03autowired;

import org.springframework.stereotype.Component;

@Component("cardBC")  // 빈의 이름을 직접 지정할 수 있다.
public class BCCard implements ICard {
    @Override
    public void buy(String itemName) {
        System.out.println("BC 카드로 " + itemName + "을 샀다.");
    }
}
