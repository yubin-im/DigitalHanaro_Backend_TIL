import java.util.Scanner;

// 6번 문제: 별찍기
public class ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("3 ~ 99까지의 홀수 중 정수를 입력하세요: ");
        int num = scanner.nextInt();

        if (num >= 3 && num <= 99) {
            if (num % 2 == 1) {
                pyramid(num);
            } else {
                System.out.println("홀수를 입력해주세요!");
            }
        } else {
            System.out.println("3 ~ 99 중에서 입력해주세요!");
        }
    }

    public static void pyramid(int num) {
        for (int i = 1; i <= num; i += 2) {
            for (int j = 0; j < (num - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
