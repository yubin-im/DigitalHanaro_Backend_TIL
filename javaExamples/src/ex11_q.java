public class ex11_q {
    public static void main(String[] args) {
        // 연습문제
        // 1. 10은 2의 배수인지 true/false로 출력하시오.
        System.out.println(10 % 2 == 0);

        // 2. 10은 4의 배수이면서 2의 배수인지 true/false로 출력하시오.
        System.out.println((10 % 4 == 0) && (10 % 2 == 0));

        // 3. 15는 10 이상이면서 20 미만인지 출력하시오.
        System.out.println((15 >= 10) && (15 < 20));

        // 4. 3은 9의 약수이면서 15의 약수인지 출력하시오.
        System.out.println((9 % 3 == 0) && (15 % 3 == 0));
    }
}
