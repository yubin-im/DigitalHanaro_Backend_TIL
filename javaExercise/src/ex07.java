import java.util.Scanner;

// 7번 문제: 수열의 합
public class ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("50이하의 정수를 입력해주세요: ");
        int n = scanner.nextInt();

        if (n >= 1 && n <= 50) {
            System.out.println("수열의 합: " + sequence(n));
        } else {
            System.out.println("50이하의 정수를 입력해주세요!");
        }
    }

    static int sequence(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }
        return sum;
    }
}
