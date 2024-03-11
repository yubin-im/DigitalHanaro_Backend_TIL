package unit03_dataTypes_operators;

public class ex12_q {
    public static void main(String[] args) {
        // 연습 문제
        // 다음 코드를 삼항 연산자로 변경 하시오
        int a = 10;
        String result;

        if (a > 0) {
            result = "정상";
        } else {
            result = "비정상";
        }
        System.out.println(result);

        // 삼항 연산자로 변경
        String result2 = (a > 0) ? "정상" : "비정상";
        System.out.println(result2);
    }
}
