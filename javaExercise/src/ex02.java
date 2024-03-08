// 2번 문제 - 로또 번호 발생기
public class ex02 {
    public static void main(String[] args) {
        int[] lotto = new int[6];

        for (int i = 0; i < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            System.out.print(num + " ");
            lotto[i] = num;

            for (int j = 1; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    System.out.print("(중복발생! 재추첨) ");
                    i--;  // 한번 더 추첨
                    break;
                }
            }
        }
    }
}
