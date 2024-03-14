import java.util.Random;
import java.util.Scanner;

// 9번 문제: 숫자 스무고개
public class ex09 {
    public static void main(String[] args) {
        checkingNum();
    }

    static void checkingNum() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int com = random.nextInt(100) + 1;
        System.out.println("컴퓨터의 숫자: " + com);

        while (true) {
            System.out.print("번호를 입력하세요: ");
            int user = scanner.nextInt();

            if (com > user) {
                System.out.println("번호가 정답보다 작습니다.");
            } else if (com < user) {
                System.out.println("번호가 정답보다 큽니다.");
            } else {
                System.out.println("정답입니다.");
                break;
            }
        }
    }
}
