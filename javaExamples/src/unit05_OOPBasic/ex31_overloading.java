package unit05_OOPBasic;

public class ex31_overloading {
    static void echo() {
        System.out.println("echo");
    }

    static void echo(int x) {
        System.out.println("echo: " + x);
    }

    static void echo(String msg) {
        System.out.println("echo: " + msg);
    }


    // 연습문제 - 오버로딩 연습
    // 메소드(함수) 이름 : calc
    // 반환형은 없음.
    // 1. 매개변수 정수형 1개일때는 그냥 변수값만 출력
    // 2. 매개변수 정수형 2개일때는 두 변수의 합계를 출력
    // 3. 매개변수 정수형 3개일때는 세 변수중에서 최대값을 출력하시오.
    static void calc(int n) {
        System.out.println(n);
    }

    static void calc(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    static void calc(int n1, int n2, int n3) {
        System.out.println(Math.max(n1, Math.max(n2, n3)));
    }

    public static void main(String[] args) {
        // 메소드 오버로딩 (method overloading)
        // 매개변수의 타입과 갯수를 다르게 함으로 함수의 기능 확장
        // 같은 이름의 함수를 사용할 수 있다.
        echo();
        echo(10);
        echo("message");

        calc(1);
        calc(1, 2);
        calc(1, 2, 3);
    }
}
