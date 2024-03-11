import java.util.Scanner;

// 4번 문제: 컴퓨터와 함께 369게임하기
public class ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 41; i++) {
            if (i % 2 == 0) {
                System.out.print("나: ");
                if (i % 3 == 0) {
                    String x = scanner.nextLine();
                    if (x.equals("X")) {
                        continue;
                    } else {
                        System.out.println("컴퓨터 승!");
                        System.out.println("게임종료");
                        break;
                    }
                } else {
                    String num = scanner.nextLine();
                    if (num.equals(Integer.toString(i))) {
                        continue;
                    } else {
                        System.out.println("컴퓨터 승!");
                        System.out.println("게임종료");
                        break;
                    }
                }
            } else {
                if (i % 3 == 0) {
                    System.out.println("컴퓨터: X");
                } else {
                    System.out.println("컴퓨터: " + i);
                }
            }
            if (i == 41) {
                System.out.println("무승부!");
                System.out.println("게임종료");
            }
        }
    }
}
