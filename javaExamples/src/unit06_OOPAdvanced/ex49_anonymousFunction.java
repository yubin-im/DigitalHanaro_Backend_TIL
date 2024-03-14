package unit06_OOPAdvanced;

// 익명 객체 (이름없는 객체- Anonymous Object)
// 일회성 메소드 재정의시 사용
// 한번 쓰고 버릴 코드이기 때문에 굳이 이름을 붙여서 사용하지 않는다.
interface NormalCar {
    void run();
}

// 여러번 쓸거면 정식적으로 클래스 구현
class SuperCar implements NormalCar {
    @Override
    public void run() {
        System.out.println("슈퍼카가 달린다.");
    }
}

public class ex49_anonymousFunction {
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar();
        superCar.run();

        // 일회성 익명 인터페이스 구현 객체를 선언/생성한다.
        NormalCar normalCar = new NormalCar() {
            @Override
            public void run() {
                System.out.println("슈퍼카가 달린다.");
            }
        };
        normalCar.run();
    }
}
