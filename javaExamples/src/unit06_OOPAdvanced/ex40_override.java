package unit06_OOPAdvanced;

// 오버라이드 (Override)
// 부모 클래스의 메소드를 자식 클래스에서 재정의
// 부모 클래스의 메소드는 무시된다.

class Machine {
    String name = "일반기계";


    void work() {
        System.out.println("일한다.");
    }
}

class CoffeMachine extends Machine {
    String name = "커피머신";

    // 오버라이드 메소드: 반환타입, 함수이름, 매개변수 동일
    // 어노테이션: @로 시작하는 컴파일 지시어, 컴파일러에게 해당 속성을 알려준다.
    @Override
    // @Override 생략 가능
    void work() {
        System.out.println("커피머신이 일한다.");
    }
}

public class ex40_override {
    public static void main(String[] args) {
        CoffeMachine cm = new CoffeMachine();
        cm.work();
    }
}
