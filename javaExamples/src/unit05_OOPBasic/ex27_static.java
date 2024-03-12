package unit05_OOPBasic;

// static 변수/함수
// static 예약어: 정적 변수(객체)/함수를 지정할 때 사용
// 의미: 프로그램 구동시에 고정된 메모리 번지에 들어간다.
// 프로그램 종료시까지 변경되지 않는다.
// 사용이유: 시작점(Entry point)를 지정할 때 사용한다.
// 중요한 데이터를 안정적으로 저장할 때 주로 사용
// 자주 사용하는 유틸성 클래스에 지정한다. new를 안해도 클래스함수 사용가능
class BallFactory {
    int ballCount = 100;

    void make() {
        this.ballCount++;
        System.out.println("축구공 생산!");
    }
}

class FoodFactory {
    static int foddCount = 200;

    static void make() {
        foddCount++;
        System.out.println("도시락 생산!");
    }
}

public class ex27_static {
    // 전역변수 또는 중요한 데이터 저장용
    public static BallFactory ballFactory;

    public static void main(String[] args) {
        BallFactory ballFactory = new BallFactory();
        System.out.println(ballFactory.ballCount);

        // static 변수, 함수는 클래스이름 뒤에 점을 찍어서 접근
        FoodFactory.make();
        System.out.println(FoodFactory.foddCount);
    }
}
