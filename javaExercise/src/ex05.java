import java.util.Random;

// 5번 문제: 텍스트 야구 게임
public class ex05 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        System.out.println("게임시작!");

        for (int i = 1; i <= 4; i++) {
            int ball = 0;
            int strike = 0;

            System.out.println(i + "번타자");

            while (true) {
                Thread.sleep(1000);
                int num = random.nextInt(2);

                if (num == 0) {
                    System.out.println("스트라이크!");
                    strike++;
                } else {
                    System.out.println("볼~");
                    ball++;
                }

                if (ball == 4) {
                    System.out.println("1루 진루!");
                    break;
                } else if (strike == 3) {
                    System.out.println("삼진 아웃!");
                    break;
                }
            }
            if (i == 4) {
                System.out.println("게임종료!");
            }
        }
    }
}
