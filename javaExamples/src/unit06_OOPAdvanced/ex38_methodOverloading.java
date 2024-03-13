package unit06_OOPAdvanced;

// 생성자 함수: 메소드 오버로딩이 가능하다.
// 메소드 오버로딩: 매개변수의 타입과 개수를 다르게 함으로 함수를 확장하는 것

class Robot {
    String color = "빨강";
    int price = 0;

    // 기본 생성자 함수 (필드가 없는)
    public Robot() {
        System.out.println("기본 생성자 함수");
    }

    // 생성자 함수 (필드가 있는)
    public Robot(String color) {
        this.color = color;
        System.out.println("필드가 있는 생성자 함수");
    }

    public Robot(String color, int price) {
        this.color = color;
        this.price = price;
    }
}

public class ex38_methodOverloading {
    public static void main(String[] args) {
        Robot r1 = new Robot();
        Robot r2 = new Robot("파랑");

    }
}
