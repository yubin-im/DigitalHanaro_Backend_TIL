import java.util.Scanner;

// 1번 문제 - 알바천국
public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day;

        while (true) {
            System.out.print("월~일요일(1~7) 중 번호를 입력하세요.(종료는 0): ");
            day = scanner.nextInt();

            if (day >= 1 && day <= 7) {
                if (day % 2 == 0) {
                    System.out.println("enjoy!");
                } else {
                    System.out.println("oh my god~");
                }
                break;
            } else if (day == 0) {
                System.out.println("종료합니다.");
                break;
            } else {
                System.out.println("1~7 사이의 번호를 입력하세요!");
                continue;
            }
        }
    }
}
