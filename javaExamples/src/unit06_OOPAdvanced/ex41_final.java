package unit06_OOPAdvanced;

// final 필드, 메소드, 클래스
// final 필드: 상수처럼 동작, 한번 값 대입시 다시 대입 불가
// final 클래스: 상속 불가
// final 메소드: 오버라이드 불가
class FinalClass {
    String name = "파이널 클래스";
    final int price = 1000;  // final 필드 선언으로 상수

    final void disp() {

    }
}

// final 클래스 선언으로 상속 불가
//class LastClass extends FinalClass{
//
//}

//class LastClass extends FinalClass {
//    // final 메소드 선언으로 오버라이드 불가
//    @Override
//    void disp() {
//
//    }
//}

public class ex41_final {
    public static void main(String[] args) {
        FinalClass fc = new FinalClass();
//        fc.price = 2000;  // final 필드 선언으로 수정 불가

        // 상수 선언
        final double PI = 3.141592;
//        PI = 6.13;  // final 필드 선언으로 수정 불가


    }
}
