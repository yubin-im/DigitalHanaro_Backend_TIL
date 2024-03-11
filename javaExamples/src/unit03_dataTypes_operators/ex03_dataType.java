package unit03_dataTypes_operators;

public class ex03_dataType {
    public static void main(String[] args) {
        // 데이터 타입 (자료형)
        // 기본 자료형 8개
        // 정수형: int, long, short, byte
        // 실수형: float, double
        // 논리형: boolean
        // 문자형(내부적으로 숫자형): char

        // 정수형
        int myInt = 10;
        System.out.println(myInt);
        long myLong = 20L;
        System.out.println(myLong);
        short myShort = 30;
        System.out.println(myShort);
        byte myByte = 40;
        System.out.println(myByte);

        // 실수형
        float myFloat = 6.14f;
        double myDouble = 3.14d;
        System.out.println(myFloat);
        System.out.println(myDouble);

        // 논리형
        boolean myBoolean = true;
        System.out.println(myBoolean);

        // 문자형
        char myChar1 = 'A';
        System.out.println(myChar1);
        char myChar2 = '가';
        System.out.println(myChar2);
        System.out.println((int) myChar1);
        System.out.println((int) myChar2);


        // 참조 자료형
        // 문자열, 배열, 클래스(객체), 열거형

        // 문자열
        String myString = "문자열ABC";
        String myString2 = new String("문자열2");
    }
}
