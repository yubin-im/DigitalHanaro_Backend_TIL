package unit02_devEnvSetting;

public class ex02_print {
    public static void main(String[] args) {
        // 한 줄 주석문
        /*
        여러줄
        주석문
         */

        // 출력문
        System.out.println("화면 출력");
        System.out.println("화면" + "출력");
        System.out.println("화면" + 10 + 20);
        System.out.println(10 + 20 + "화면");

        // println, print, printf
        // println: 문자열 한 줄 출력 + 줄바꿈
        // print: 줄바꿈 없음
        // printf: 형식화된 출력문
        System.out.println("한 줄 출력후 줄바꿈");
        System.out.print("한 줄 출력후 줄바꿈 없음");
        System.out.printf("%d\n", 30); // 10진수
        System.out.printf("%o\n", 30); // 8진수
        System.out.printf("%x\n", 30); // 16진수
        System.out.printf("%e\n", 300.0); // 지수형 출력
    }
}
