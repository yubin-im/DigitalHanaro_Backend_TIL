package unit05_OOPBasic;

// static 초기화 블럭
class StaticClass {
    int a;
    static int b;

    // 프로그램 시작 시 호출된다. (main 함수 이전)
    static {
        b = 5;
        System.out.println("static block!");
    }

    // 생성자 함수
    // new 코드가 실행될 때 호출
    StaticClass() {
        a = 3;
        b = 10;
    }
}

public class ex35_static {
    public static void main(String[] args) {
        System.out.println(StaticClass.b);
        StaticClass s = new StaticClass();
        System.out.println(StaticClass.b);
    }
}
