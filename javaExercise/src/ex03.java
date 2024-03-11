import java.util.Scanner;

// 3번 문제: 369 게임 달인
public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1~10 사이의 정수를 입력하세요: ");
        int num = scanner.nextInt();

        if (num >= 1 && num <= 10) {
            for (int i = 1; i <= num; i++) {
                if (i % 3 == 0) {
                    System.out.print("X ");
                } else {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println("1~10 사이의 수를 입력하세요! 종료됩니다.");
        }
    }
}
