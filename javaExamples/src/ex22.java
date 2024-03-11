import java.util.Random;

public class ex22 {
    public static void main(String[] args) {
        // 연습 문제
        // 철수가 AI로봇과 가위바위보 게임을 한다.
        // 철수가 가위를 낼 확률은 1/10이고, 바위를 낼 확률은 5/10, 보를 낼 확률은 4/10이다.
        // AI로봇은 동일한 확률로 가위바위보를 낸다.
        // 팁) 1~10까지 랜덤수를 발생하여 1이면 10%, 2~6이면 50%, 7~10이면 40%의 확률임.
        // 철수가 이길 때까지 가위바위보 게임을 한다고 할때 과정과 결과를 출력하시오.
        // 출력결과
        // 철수:가위 AI로봇:가위
        // 무승부
        // 철수:바위 AI로봇:보
        // 로봇 승
        // 철수:보 AI로봇:주먹
        // 철수 승!

        // 문제 풀이 답:
        Random rand = new Random();
        while (true) {
            int randomCholsu = rand.nextInt(10) + 1;
            int randomAI = rand.nextInt(10) + 1;
            int srpCholsu = 0; //가위 0 바위 1 보 2
            int srpAI = 0;
            if (randomCholsu == 1) {
                srpCholsu = 0;
                System.out.println("철수:가위");
            } else if (randomCholsu >= 2 && randomCholsu <= 6) {
                srpCholsu = 1;
                System.out.println("철수:바위");
            } else {
                srpCholsu = 2;
                System.out.println("철수:보");
            }
            if (randomAI == 1) {
                srpAI = 0;
                System.out.println("AI:가위");
            } else if (randomAI >= 2 && randomAI <= 6) {
                srpAI = 1;
                System.out.println("AI:바위");
            } else {
                srpAI = 2;
                System.out.println("AI:보");
            }
            //가위 바위 보
            //가위 : 가위 = 무승부
            //바위 : 바위 = 무승부
            //보 : 보 = 무승부
            if (srpCholsu == srpAI) {
                System.out.println("무승부~");
            } else if (srpCholsu == 0) {
                if (srpAI == 1) {
                    System.out.println("AI 승!");
                } else {
                    System.out.println("철수 승!");
                    break;
                }
            } else if (srpCholsu == 1) {
                if (srpAI == 0) {
                    System.out.println("철수 승!");
                    break;
                } else {
                    System.out.println("AI 승!");
                }
            } else if (srpCholsu == 2) {
                if (srpAI == 0) {
                    System.out.println("AI 승!");
                } else {
                    System.out.println("철수 승!");
                    break;
                }
            }
        }

    }
}
