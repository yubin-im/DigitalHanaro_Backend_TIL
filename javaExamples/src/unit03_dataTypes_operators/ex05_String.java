package unit03_dataTypes_operators;

public class ex05_String {
    public static void main(String[] args) {
        // String 클래스
        String str1 = new String("안녕");  // 새로운 객체 생성
        String str2 = "안녕";  // 같은 내용의 리터럴 객체있는지 확인
        String str3 = "안녕";  // 같은 내용의 리터럴 객체있는지 확인, 있다면 새로 생성안하고 주소값만 복사
        String str4 = new String("안녕");  // 새로운 객체 생성

        System.out.println(str1 == str2);  // false
        System.out.println(str2 == str3);  // true
        System.out.println(str3 == str4);  // false
        System.out.println(str1 == str4);  // false

        // 문자열 연결 연산자 +
        // 산술 연산자 +
        System.out.println("한글" + "만세");
        System.out.println("한글" + 10);
        System.out.println(10 + "한글");
        System.out.println(10 + 20);

        // 연산자 우선 순위 좌->우
        System.out.println("한글" + 10 + 20);  // 모두 문자열
        System.out.println(10 + 20 + "한글");  // 정수끼리 연산

        // 기본 자료형 -> 문자열 형으로 변환
        System.out.println(String.valueOf(10));
        // 문자열 형 -> 정수형
        int num = Integer.parseInt("10");
        System.out.println(num);
    }
}
