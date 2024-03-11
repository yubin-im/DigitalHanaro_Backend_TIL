import java.util.Scanner;

public class ex19_doubleFor {
    public static void main(String[] args) {
        // 이중 반복문
        // 구구단 출력 (2~9단)
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + (i * j));
            }
        }


        // 연습문제 - 별찍기
        // 1. 다음과 같이 출력하시오.
        // 입력 예)
        // 5
        // 출력 예)
        // *****
        // *****
        // *****
        // *****
        // *****
        // 입력 예)
        // 3
        // 출력 예)
        // ***
        // ***
        // ***
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println();
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
        }
        System.out.println();

        System.out.println("-------------------------");
        // 2. 다음과 같이 출력하시오.
        // 입력 예)
        // 3
        // 출력 예)
        //  *
        // **
        //***
        // 입력 예)
        // 5
        // 출력 예)
        //    *
        //   **
        //  ***
        // ****
        //*****
        System.out.print("숫자를 입력하세요: ");
        int num2 = scanner.nextInt();

        for (int i = 0; i <= num2; i++) {
            for (int j = num2; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------------");
        // 3. 다음과 같이 출력하시오.
        // 입력 예) 5이상의 홀수
        // 5
        // 출력 예)
        //*****
        //*  **
        //* * *
        //**  *
        //*****
        // 입력 예)
        // 7
        // 출력 예)
        //*******
        //*    **
        //*   * *
        //*  *  *
        //* *   *
        //**    *
        //*******

        // 문제 풀이
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) { //첫행 마지막행
                    System.out.print("*");
                } else if (j == 0 || j == n - 1) { //중간행
                    System.out.print("*");
                } else if (n - 1 - i == j) { //대각선
                    System.out.print("*");
                } else {
                    System.out.print(" ");//그외
                }
            }
            System.out.println();
        }
    }
}
