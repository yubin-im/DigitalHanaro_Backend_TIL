package unit03_dataTypes_operators;

import java.util.Scanner;

public class ex13_Scanner {
    public static void main(String[] args) {
        // Scanner 클래스 함수들
        // next(): 문자열의 공백까지만 입력 받는다.
        // nextInt(): 문자열을 받아서 정수로 반환해준다.
        // nextFloat(): 문자열을 받아서 실수로 반환해준다.
        // nextDouble(): 문자열을 받아서 실수로 반환해준다.
        Scanner scan = new Scanner(System.in);

        System.out.print("문자를 입력하세요: ");
        String str1 = scan.nextLine();
        System.out.println(str1);

        String str2 = scan.next();
        System.out.println(str2);

        // java.util.InputMismatchException
        // 정수로 입력해야하는데 다른 타입을 입력한 경우 예외 발생
        // next() 함수에 저장된 버퍼 메모리가 저장되지 않아서 예외 발생
        // 해결방안: nextLine() 함수를 한번 실행해준다.
        scan.nextLine();

        int num1 = scan.nextInt();
        System.out.println(num1);

        // scan 객체가 사용중인 메모리 정리
        scan.close();
    }
}
