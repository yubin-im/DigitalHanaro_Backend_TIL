package unit05_OOPBasic;

class MyClass {
    // 메서드 4가지 패턴
    // 선언부
    // 1. 매개변수 X 반환형 X
    void func1() {
        System.out.println("func1");
    }

    // 2. 매개변수 O 반환형 X
    void func2(int x, int y) {
        System.out.println("func2");
        System.out.println(x + ", " + y);
    }

    // 3. 매개변수 X 반환형 O
    int func3() {
        System.out.println("func3");
        return 10;
    }

    // 4. 매개변수 O 반환형 O
    int func4(int x, int y) {
        System.out.println("func4");
        return x + y;
    }
}

public class ex28_method {
    public static void main(String[] args) {
        // 호출부
        MyClass myClass = new MyClass();

        myClass.func1();
        myClass.func2(10, 20);
        myClass.func3();
        myClass.func4(10, 20);
    }
}
