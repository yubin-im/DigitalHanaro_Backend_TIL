package unit06_OOPAdvanced;

public class ex53_wrapperClass {
    public static void main(String[] args) {
        // Wrapper class
        // 기본 자료형 8개를 감싸서 클래스로 만든 것
        // 클래스로 만들어야 다형성 이용 가능

        // 기본 자료형 8개: int, long, short, byte, char, boolean, float, double
        // 래퍼 클래스: Integer, Long, Short, Byte, Charactor, Boolean, Float, Double
        // 숫자 클래스: Number <- int, long, short, byte, float, double

//        Integer intValue1 = new Integer(10);  // JDK9부터는 비추천
        Integer intValue2 = 10;
        System.out.println(intValue2);
        System.out.println(intValue2);
    }
}
