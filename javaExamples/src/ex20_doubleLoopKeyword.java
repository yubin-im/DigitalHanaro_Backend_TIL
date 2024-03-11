public class ex20_doubleLoopKeyword {
    public static void main(String[] args) {
        // 중첩 반복문에서의 제어: break, continue, lable
        // 레이블: 반복문의 제어 위치
        loop1:
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            loop2:
            for (int j = 0; j < 5; j++) {
                if (j > 3)
                    break loop1;  // loop1 for문이 종료됨.
                if (j % 2 == 1)
                    continue loop1;
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
