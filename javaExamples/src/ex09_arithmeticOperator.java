public class ex09_arithmeticOperator {
    public static void main(String[] args) {
        // 산술 연산자: +, -, *, /, %, <<, >>, >>>
        int i = 10;
        int j = 3;

        System.out.println(i + j);
        System.out.println(i - j);
        System.out.println(i * j);
        System.out.println(i & j);  // 나눗셈의 몫
        System.out.println(i % j);  // 나눗셈의 나머지

        
        // 연습문제
        // 나머지 연산자를 이용하여
        int k = 123;
        // 1. 일의 자릿수 3을 출력하시오.
        System.out.println(k % 10);
        // 2. 십의 자릿수 2를 출력하시오.
        System.out.println((k % 100) / 10);
        // 3. 백의 자릿수 1을 출력하시오.
        System.out.println(k / 100);

        double d = 3.567;
        // 4. 소숫점 첫째자리를 출력하시오. (5)
        System.out.println((Math.round(d * 100) % 100) / 10);
        // 5. 소숫점 첫째자리에서 반올림하여 출력하시오. (4.0)
        System.out.println(Math.round(d) * 1.0);
        // 6. 소숫점 둘째자리에서 반올림하여 출력하시오. (3.6)
        System.out.println(Math.round(d * 10) / 10.0);

    }
}
